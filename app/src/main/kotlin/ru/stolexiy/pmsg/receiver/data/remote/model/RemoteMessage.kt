package ru.stolexiy.pmsg.receiver.data.remote.model

import ru.stolexiy.pmsg.receiver.domain.model.DomainMessage

data class RemoteMessage(
    val id: Int,
    val message: String,
    val isShown: Boolean,
    val showTimestamp: Long,
    val shownTimestamp: Long?
) {
    companion object {
        fun DomainMessage.toRemoteMessage() = RemoteMessage(
            id = id ?: 0,
            message = message,
            isShown = isShown,
            showTimestamp = showTimestamp.timeInMillis,
            shownTimestamp = shownTimestamp?.timeInMillis
        )
    }
}
