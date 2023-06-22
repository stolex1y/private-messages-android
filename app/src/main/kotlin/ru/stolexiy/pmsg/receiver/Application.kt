package ru.stolexiy.pmsg.receiver

import android.app.Application
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp
import ru.stolexiy.pmsg.data.model.RemoteMessage.Companion.toRemoteMessage
import ru.stolexiy.pmsg.domain.model.DomainMessage
import timber.log.Timber

@HiltAndroidApp
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        val db = Firebase.firestore
        val message = DomainMessage(
            message = "Test message"
        )
        db.collection("messages")
            .add(message.toRemoteMessage())
            .addOnSuccessListener {
                Timber.d("success adding")
            }.addOnFailureListener {
                Timber.e(it)
            }
    }
}