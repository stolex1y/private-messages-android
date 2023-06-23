package ru.stolexiy.pmsg.domain.paging

class Sort(
    var field: String,
    var order: Order,
    var then: Sort? = null
) {
    fun then(sort: Sort): Sort {
        then = sort
        return sort
    }

    enum class Order {
        ASC,
        DESC
    }
}