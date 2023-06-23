package ru.stolexiy.pmsg.common

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import ru.stolexiy.pmsg.common.DateUtils.toCalendar
import java.lang.reflect.Type
import java.util.Calendar

class CalendarSerializer : JsonSerializer<Calendar> {
    override fun serialize(
        src: Calendar?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src?.timeInMillis)
    }
}

class CalendarDeserializer : JsonDeserializer<Calendar> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Calendar? {
        return json?.asJsonPrimitive?.asLong?.toCalendar()
    }
}
