package ru.stolexiy.pmsg.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Converters {
    @JvmStatic
    fun calendarToString(pattern: String): Converter<Calendar?, String> = Converter { calendar ->
        return@Converter if (calendar == null)
            ""
        else
            SimpleDateFormat(pattern, Locale.getDefault()).format(calendar.time)
    }

    val CALENDAR_DMY_CONVERTER = calendarToString("dd.MM.yyyy")
}
