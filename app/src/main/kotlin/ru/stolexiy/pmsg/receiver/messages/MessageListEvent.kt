package ru.stolexiy.pmsg.receiver.messages

import ru.stolexiy.pmsg.common.ui.util.udf.IEvent

sealed interface MessageListEvent : IEvent {
    object Load : MessageListEvent
}
