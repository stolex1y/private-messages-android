package ru.stolexiy.pmsg.domain.paging

class Filter<T : Field>(
    var field: T,
    var value: Any,
    var nextFilter: Filter<T>? = null
) {
    fun then(filter: Filter<T>): Filter<T> {
        nextFilter = filter
        return filter
    }
}
