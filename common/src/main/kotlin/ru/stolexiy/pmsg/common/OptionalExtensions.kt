package ru.stolexiy.pmsg.common

import java.util.Optional

object OptionalExtensions {
    fun <T : Any> T?.toOptional(): Optional<T> {
        return this?.let {
            Optional.of(it)
        } ?: Optional.empty()
    }
}
