package ru.stolexiy.pmsg.receiver.ui.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ru.stolexiy.pmsg.receiver.R
import ru.stolexiy.pmsg.receiver.databinding.FragmentMessageListBinding
import ru.stolexiy.pmsg.receiver.ui.messages.model.MessageListItem
import ru.stolexiy.pmsg.ui.util.binding.BindingDelegate.Companion.bindingDelegate
import ru.stolexiy.pmsg.ui.util.di.CustomAbstractSavedStateViewModelFactory.Companion.assistedViewModels
import ru.stolexiy.pmsg.ui.util.fragment.repeatOnViewLifecycle
import ru.stolexiy.pmsg.ui.util.recyclerview.SingleLayoutAdapter
import javax.inject.Inject

@AndroidEntryPoint
class MessageListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: MessageListViewModel.Factory

    private val viewModel by assistedViewModels({ viewModelFactory })
    private val binding: FragmentMessageListBinding by bindingDelegate()
    private val adapter =
        SingleLayoutAdapter<MessageListItem, String>(R.layout.list_item_message)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_message_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerViewMessages.adapter = adapter
        }
        observeState()
        observeData()
        dispatchEvent(MessageListEvent.Load)
    }

    private fun dispatchEvent(event: MessageListEvent) {
        viewModel.dispatchEvent(event)
    }

    private fun observeState() {
        repeatOnViewLifecycle {
            viewModel.state.collect { state ->
                when (state) {
                    is MessageListViewModel.State.Error -> onError(state.error)
                    MessageListViewModel.State.Init -> {}
                    MessageListViewModel.State.Loaded -> {}
                }
            }
        }
    }

    private fun observeData() {
        repeatOnViewLifecycle {
            viewModel.data.collectLatest {
                adapter.submitList(it.messages.toMutableList())
            }
        }
    }

    private fun onError(errorMsg: Int) {
        Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_LONG).show()
    }
}
