package ru.stolexiy.nwl.model

import java.util.*

data class Message(
    val id: Int? = null,
    private var message: String,
    private var isShown: Boolean = false,
    val creationDateTime: Calendar = Calendar.getInstance(),
    private var shownDateTime: Calendar?
) {
    init {
        if (message == "")
            throw IllegalArgumentException()
        if (!isShown && shownDateTime != null)
            throw IllegalArgumentException()
    }

    fun setMessage(msg: String) {
        if (msg == "")
            throw IllegalArgumentException()
        else
            message = msg
    }

    fun getMessage() = message
    fun getShownDateTime() = shownDateTime
    fun isShown() = isShown

    fun setIsShown(isShown: Boolean) {
        this.isShown = isShown
        shownDateTime = if (isShown)
            Calendar.getInstance()
        else
            null
    }


}