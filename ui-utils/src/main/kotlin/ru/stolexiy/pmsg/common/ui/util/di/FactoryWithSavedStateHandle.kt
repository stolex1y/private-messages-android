package ru.stolexiy.pmsg.common.ui.util.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface FactoryWithSavedStateHandle<T : ViewModel> {
    fun create(savedStateHandle: SavedStateHandle): T
}
