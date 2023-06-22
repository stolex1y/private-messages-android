package ru.stolexiy.pmsg.data.model

import ru.stolexiy.pmsg.common.DateUtils.toCalendar
import ru.stolexiy.pmsg.domain.model.DomainMessage

data class RemoteMessage(
    val message: String,
    val isShown: Boolean,
    val showTimestamp: Long,
    val shownTimestamp: Long?
) {
    companion object {
        const val COLLECTION = "messages"
        const val FIELD_SHOW_TIMESTAMP = "showTimestamp"
        const val FIELD_SHOWN_TIMESTAMP = "shownTimestamp"
        const val FIELD_IS_SHOWN = "shown"
        const val FIELD_MESSAGE = "message"

        fun DomainMessage.toRemoteMessage() = RemoteMessage(
            message = message,
            isShown = isShown,
            showTimestamp = showTimestamp.timeInMillis,
            shownTimestamp = shownTimestamp?.timeInMillis
        )
    }

    fun toDomainMessage(id: String) = DomainMessage(
        id = id,
        message = message,
        isShown = isShown,
        showTimestamp = showTimestamp.toCalendar(),
        shownTimestamp = shownTimestamp?.toCalendar(),
    )
}
