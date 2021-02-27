package com.example.core.coroutines

sealed class Result<T> {
    data class OnSuccess<T>(val value: T) : Result<T>()
    class OnError<T> : Result<T>()
    class OnLoading<T> : Result<T>()
    class OnUnauthorized<T> : Result<T>()
}