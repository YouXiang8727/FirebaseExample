package com.youxiang8727.firebaseexample.data.network

sealed class NetworkResult<out T> {
    data class Success<T>(val result: T): NetworkResult<T>()

    data class Error(val throwable: Throwable): NetworkResult<Nothing>()

    data object Loading: NetworkResult<Nothing>()
}