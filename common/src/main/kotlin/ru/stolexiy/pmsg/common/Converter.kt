package ru.stolexiy.pmsg.common

fun interface Converter<S, T> {
    fun convert(source: S): T
}
