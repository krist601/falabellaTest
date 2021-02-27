package com.example.core.coroutines

import com.example.core.extension.LiveResult
import com.example.core.extension.postError
import com.example.core.extension.postLoading
import com.example.core.extension.postSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class ResultUnitUseCase<T>(
    override val backgroundContext: CoroutineContext,
    override val foregroundContext: CoroutineContext
) : BaseUnitUseCase<LiveResult<T>>(
    backgroundContext, foregroundContext
) {
    protected abstract suspend fun executeOnBackground(): T?

    override fun execute(liveData: LiveResult<T>) {
        CoroutineScope(foregroundContext + newJob()).launch {
            liveData.postLoading()

            runCatching {
                withContext(backgroundContext) { executeOnBackground()!! }
            }.onSuccess { response ->
                liveData.postSuccess(response)
            }.onFailure {
                liveData.postError()
            }
        }
    }
}
