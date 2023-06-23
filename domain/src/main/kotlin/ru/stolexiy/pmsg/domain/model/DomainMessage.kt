package ru.stolexiy.pmsg.domain.model

import ru.stolexiy.pmsg.common.DateUtils.isPast
import ru.stolexiy.pmsg.domain.paging.Field
import java.util.Calendar

data class DomainMessage(
    val id: String? = null,
    val message: String,
    val isShown: Boolean = false,
    val showTimestamp: Calendar = Calendar.getInstance(),
    val shownTimestamp: Calendar? = null
) {
    init {
        require(message.isNotBlank())
        if (isShown)
            require(shownTimestamp?.isPast() == true)
        else
            require(shownTimestamp == null)
    }

    enum class Fields(
        override val fieldName: String
    ) : Field {
        SHOW_TIMESTAMP("showTimestamp"),
        SHOWN_TIMESTAMP("shownTimestamp"),
        IS_SHOWN("isShown"),
        MESSAGE("message"),
    }
}
