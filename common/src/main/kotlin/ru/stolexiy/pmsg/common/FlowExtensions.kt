package ru.stolexiy.pmsg.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

object FlowExtensions {
    fun <T> Flow<T>.mapToResult() =
        this.map { Result.success(it) }.catch {
            emit(Result.failure(it))
        }
}
