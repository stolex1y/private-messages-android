package ru.stolexiy.pmsg.common.ui.util.di

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Provider

inline fun <reified EP> Fragment.entryPointAccessors(): Lazy<EP> {
    return lazy {
        EntryPointAccessors.fromFragment<EP>(requireParentFragment())
    }
}

inline fun <reified EP> entryPointApplicationAccessor(contextProvider: Provider<Context>): Lazy<EP> {
    return lazy {
        EntryPointAccessors.fromApplication<EP>(contextProvider.get())
    }
}
