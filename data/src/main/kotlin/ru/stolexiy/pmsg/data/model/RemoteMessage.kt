package ru.stolexiy.pmsg.data.model

import ru.stolexiy.pmsg.common.DateUtils.toCalendar
import ru.stolexiy.pmsg.domain.model.DomainMessage
import ru.stolexiy.pmsg.domain.paging.Filter
import java.util.Calendar

class RemoteMessage(
    var message: String,
    var isShown: Boolean,
    var showTimestamp: Long,
    var shownTimestamp: Long?
) {
    constructor() : this(
        message = "",
        isShown = false,
        showTimestamp = 0,
        shownTimestamp = null
    )

    companion object {
        const val COLLECTION = "messages"

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
