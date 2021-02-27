package com.example.falabellatest.domain.useCases

import com.example.core.extension.LiveResult
import com.example.core.extension.postError
import com.example.core.extension.postLoading
import com.example.core.extension.postSuccess
import com.example.falabellatest.domain.entities.HeaderMemory
import com.example.falabellatest.domain.repository.EconomicIndicatorsRepository
import com.example.falabellatest.domain.util.RESPONSE_ERROR_CODE
import com.example.falabellatest.domain.util.RESPONSE_SUCCESS_CODE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EconomicIndicatorsUseCases(
    val repository: EconomicIndicatorsRepository
) {
    fun getEconomicIndicators(liveData: LiveResult<HeaderMemory?>){
        CoroutineScope(Dispatchers.IO).launch {
            liveData.postLoading()
            repository.getEconomicIndicators().let{ response ->
                when (response.first) {
                    RESPONSE_SUCCESS_CODE -> liveData.postSuccess(response.second)
                    RESPONSE_ERROR_CODE -> liveData.postError()
                }
            }
        }
    }
}