package dev.mlds.wallet.domain.models

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val exception: Throwable) : Resource<Nothing>()
    data class HttpError(val data: ApiError) : Resource<Nothing>()
}