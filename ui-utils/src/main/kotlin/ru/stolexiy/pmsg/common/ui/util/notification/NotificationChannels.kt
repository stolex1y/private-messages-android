package ru.stolexiy.pmsg.common.ui.util.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import ru.stolexiy.pmsg.common.ui.util.R

object NotificationChannels {
    const val BACKGROUND_WORK = "BACKGROUND"

    @RequiresApi(api = Build.VERSION_CODES.O)
    fun NotificationManager.initChannels(appContext: Context) {
        val channels: MutableList<NotificationChannel> = mutableListOf()
        channels += NotificationChannel(
            BACKGROUND_WORK,
            appContext.getString(R.string.background_work),
            NotificationManager.IMPORTANCE_MIN
        )
        createNotificationChannels(channels)
    }
}
