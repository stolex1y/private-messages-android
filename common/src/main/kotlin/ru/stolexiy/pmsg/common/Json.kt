package ru.stolexiy.pmsg.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.Calendar

object Json {
    val serializer: Gson by lazy {
        GsonBuilder()
            .registerTypeHierarchyAdapter(Calendar::class.java, CalendarSerializer())
            .registerTypeHierarchyAdapter(Calendar::class.java, CalendarDeserializer())
            .create()
    }
}
