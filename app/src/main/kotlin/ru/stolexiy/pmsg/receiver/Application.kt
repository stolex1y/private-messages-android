package ru.stolexiy.pmsg.receiver

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.firestore.ktx.memoryCacheSettings
import com.google.firebase.firestore.ktx.persistentCacheSettings
import com.google.firebase.ktx.Firebase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import ru.stolexiy.pmsg.ui.util.di.entryPointApplicationAccessor
import timber.log.Timber

@HiltAndroidApp
class Application : Application(), Configuration.Provider {
    private val entryPoint by entryPointApplicationAccessor<BaseApplicationEntryPoint>(
        ::getApplicationContext
    )

    private val workerFactory: HiltWorkerFactory by lazy {
        entryPoint.workerFactory()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    private fun firestoreSettings(): FirebaseFirestoreSettings =
        firestoreSettings {
            setLocalCacheSettings(memoryCacheSettings {})
        }

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface BaseApplicationEntryPoint {
        fun workerFactory(): HiltWorkerFactory
    }
}
