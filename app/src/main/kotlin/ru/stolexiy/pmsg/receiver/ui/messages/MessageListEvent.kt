package ru.stolexiy.pmsg.receiver.ui.messages

import ru.stolexiy.pmsg.ui.util.udf.IEvent

sealed interface MessageListEvent : IEvent {
    object Load : MessageListEvent
}
