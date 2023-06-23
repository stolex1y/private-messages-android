package ru.stolexiy.pmsg.ui.util.fragment

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun Fragment.repeatOnParentViewLifecycle(
    state: Lifecycle.State = Lifecycle.State.RESUMED,
    block: suspend () -> Unit
) {
    val viewLifecycleOwner =
        parentFragment?.viewLifecycleOwner ?: requireActivity()
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(state) {
            block()
        }
    }
}

fun Fragment.repeatOnViewLifecycle(
    state: Lifecycle.State = Lifecycle.State.RESUMED,
    block: suspend () -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(state) {
            block()
        }
    }
}

fun Fragment.parentView(): View? {
    return if (parentFragment != null)
        parentFragment?.view
    else
        activity?.findViewById<ViewGroup>(android.R.id.content)?.rootView
}

fun Fragment.requireParentView(): View {
    return parentView()!!
}
