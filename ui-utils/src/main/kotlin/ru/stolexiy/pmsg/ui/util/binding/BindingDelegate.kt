package ru.stolexiy.pmsg.ui.util.binding

import android.R
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import javax.inject.Provider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class BindingDelegate<T : ViewDataBinding> private constructor(
    private val viewProvider: Provider<View>,
    private val lifecycleProvider: Provider<Lifecycle>
) : ReadOnlyProperty<Any, T>,
    DefaultLifecycleObserver {

    private var binding: T? = null

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        owner.lifecycle.removeObserver(this)
        binding = null
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        require(lifecycleProvider.get().currentState.isAtLeast(Lifecycle.State.INITIALIZED))

        if (binding == null) {
            binding = DataBindingUtil.bind(viewProvider.get())
            lifecycleProvider.get().addObserver(this)
        }
        return binding!!
    }

    companion object {
        fun <T : ViewDataBinding> Fragment.bindingDelegate(): BindingDelegate<T> {
            return BindingDelegate(
                { view },
                { viewLifecycleOwner.lifecycle }
            )
        }

        fun <T : ViewDataBinding> AppCompatActivity.bindingDelegate(): BindingDelegate<T> {
            return BindingDelegate(
                { findViewById<ViewGroup>(R.id.content).rootView },
                { lifecycle }
            )
        }
    }
}
