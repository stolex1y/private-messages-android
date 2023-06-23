package ru.stolexiy.pmsg.common.ui.util.di

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.savedstate.SavedStateRegistryOwner
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class CustomAbstractSavedStateViewModelFactory<out T : ViewModel>(
    owner: SavedStateRegistryOwner,
    private val viewModelProducer: (SavedStateHandle) -> T,
    defaultArgs: Bundle?
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = viewModelProducer(handle) as T

    companion object {
        inline fun <reified T : ViewModel> Fragment.assistedViewModels(
            noinline ownerProducer: () -> ViewModelStoreOwner = { this },
            noinline viewModelProducer: (SavedStateHandle) -> T
        ) = viewModels<T>(ownerProducer) {
            CustomAbstractSavedStateViewModelFactory(this, viewModelProducer, this.arguments)
        }

        inline fun <reified T : ViewModel, F : FactoryWithSavedStateHandle<T>> Fragment.assistedViewModels(
            factoryProvider: Provider<F>,
            noinline ownerProducer: () -> ViewModelStoreOwner = { this }
        ) = viewModels<T>(ownerProducer) {
            CustomAbstractSavedStateViewModelFactory(
                this,
                { factoryProvider.get().create(it) },
                this.arguments
            )
        }
    }
}
