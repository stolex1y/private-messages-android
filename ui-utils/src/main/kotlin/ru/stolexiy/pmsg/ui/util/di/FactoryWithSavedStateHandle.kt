package ru.stolexiy.pmsg.ui.util.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface FactoryWithSavedStateHandle<T : ViewModel> {
    fun create(savedStateHandle: SavedStateHandle): T
}
