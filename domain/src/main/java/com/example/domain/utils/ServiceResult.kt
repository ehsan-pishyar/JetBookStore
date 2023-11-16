package com.example.domain.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException

private const val RETRY_TIME_IN_MILLIS = 15_000L

sealed interface ServiceResult<out T> {
    data class Success<T>(val data: T): ServiceResult<T>
    data class Error(val throwable: Throwable? = null): ServiceResult<Nothing>
    object Loading: ServiceResult<Nothing>
}

fun <T> Flow<T>.asServiceResult(): Flow<ServiceResult<T>> {
    return this
        .map<T, ServiceResult<T>> {
            ServiceResult.Success(it)
        }
        .onStart { emit(ServiceResult.Loading) }
        .retryWhen { cause, _ ->
            if (cause is IOException) {
                emit(ServiceResult.Error(cause))
                delay(RETRY_TIME_IN_MILLIS)
                true
            } else {
                false
            }
        }
        .catch { ServiceResult.Error(it) }
}