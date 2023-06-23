package ru.stolexiy.pmsg.receiver.ui.messages.model

import ru.stolexiy.pmsg.domain.model.DomainMessage
import ru.stolexiy.pmsg.ui.util.recyclerview.ListItem
import java.util.Calendar

data class MessageListItem(
    override val id: String,
    val message: String,
    val shownTimestamp: Calendar,
) : ListItem<String> {
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
