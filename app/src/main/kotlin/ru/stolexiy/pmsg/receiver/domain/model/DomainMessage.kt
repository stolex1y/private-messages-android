package ru.stolexiy.pmsg.receiver.domain.model

import ru.stolexiy.pmsg.receiver.common.DateUtils.isNotPast
import ru.stolexiy.pmsg.receiver.common.DateUtils.isPast
import java.util.*

data class DomainMessage(
    val id: Int? = null,
    val message: String,
    val isShown: Boolean = false,
    val showTimestamp: Calendar = Calendar.getInstance(),
    val shownTimestamp: Calendar? = null
) {
    init {
        require(message.isNotBlank())
        require(showTimestamp.isNotPast())
        if (isShown)
            require(shownTimestamp?.isPast() == true)
        else
            require(shownTimestamp == null)
    }
}