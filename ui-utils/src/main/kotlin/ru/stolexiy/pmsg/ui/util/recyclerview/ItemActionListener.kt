package ru.stolexiy.pmsg.ui.util.recyclerview

interface ItemActionListener<T : ListItem<I>, I> {
    fun onClick(item: T) {}
    fun onSwipeToEnd(item: T) {}
    fun onSwipeToStart(item: T) {}
    fun onMoveTo(item: T, to: T) {}
}
