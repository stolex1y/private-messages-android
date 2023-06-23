package ru.stolexiy.pmsg.common.ui.util.recyclerview

class SingleLayoutAdapter<T : ListItem<I>, I>(private val layoutId: Int) : BaseListAdapter<T, I>() {
    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }
}
