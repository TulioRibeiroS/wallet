package dev.mlds.wallet.data.models

sealed class Result<out T> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
}
