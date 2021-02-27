package com.example.core.extension

import androidx.lifecycle.MutableLiveData
import com.example.core.coroutines.Completable
import com.example.core.coroutines.Result

typealias LiveResult<T> = MutableLiveData<Result<T>>
typealias LiveCompletable = MutableLiveData<Completable>

@JvmName("postCompleteResult")
fun <T> LiveResult<T>.postSuccess(value: T) = postValue(Result.OnSuccess(value))

@JvmName("postCompleteResult")
fun <T> LiveResult<T>.postError() = postValue(Result.OnError())

@JvmName("postLoadingResult")
fun <T> LiveResult<T>.postLoading() = postValue(Result.OnLoading())

@JvmName("postCancelResult")
fun <T> LiveResult<T>.postUnauthorized() = postValue(Result.OnUnauthorized())