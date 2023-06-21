package ru.stolexiy.pmsg.common

import java.util.Calendar

object DateUtils {
    @JvmStatic
    fun todayCalendar(): Calendar = Calendar.getInstance().apply {
        set(get(Calendar.YEAR), get(Calendar.MONTH), get(Calendar.DAY_OF_MONTH), 0, 0, 0)
    }

    @JvmStatic
    fun Long.toCalendar(): Calendar =
        Calendar.getInstance().apply { timeInMillis = this@toCalendar }

    @JvmStatic
    fun Calendar.isNotPast(): Boolean = this.timeInMillis >= todayCalendar().timeInMillis

    @JvmStatic
    fun Calendar.isPast(): Boolean = !isNotPast()
}
