package ru.stolexiy.pmsg.receiver.messages.model

import ru.stolexiy.pmsg.common.Converters
import ru.stolexiy.pmsg.domain.model.DomainMessage
import ru.stolexiy.pmsg.common.ui.util.recyclerview.ListItem
import java.util.Calendar

data class MessageListItem(
    override val id: String,
    val message: String,
    val shownTimestamp: Calendar,
) : ListItem<String> {
    val shownTimestampStr: String
        get() = Converters.CALENDAR_DMY_CONVERTER.convert(shownTimestamp)

    companion object {
        private fun DomainMessage.toMessageListItem(): MessageListItem {
            requireNotNull(id)
            requireNotNull(shownTimestamp)
            return MessageListItem(
                id = id!!,
                message = message,
                shownTimestamp = shownTimestamp!!
            )
        }

        fun List<DomainMessage>.toMessageListItems(): List<MessageListItem> {
            return map { it.toMessageListItem() }
        }
    }
}
