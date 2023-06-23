package ru.stolexiy.pmsg.receiver.ui.messages

import androidx.lifecycle.SavedStateHandle
import androidx.work.WorkManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.stolexiy.pmsg.common.FlowExtensions.mapToResult
import ru.stolexiy.pmsg.common.di.CoroutineComponentNames
import ru.stolexiy.pmsg.domain.repository.MessageRepository
import ru.stolexiy.pmsg.receiver.ui.messages.model.MessageListItem
import ru.stolexiy.pmsg.receiver.ui.messages.model.MessageListItem.Companion.toMessageListItems
import ru.stolexiy.pmsg.ui.util.di.FactoryWithSavedStateHandle
import ru.stolexiy.pmsg.ui.util.udf.AbstractViewModel
import ru.stolexiy.pmsg.ui.util.udf.IData
import ru.stolexiy.pmsg.ui.util.udf.IState
import javax.inject.Named
import javax.inject.Provider

class MessageListViewModel @AssistedInject constructor(
    private val messageRepository: MessageRepository,
    @Named(CoroutineComponentNames.APPLICATION_SCOPE) applicationScope: CoroutineScope,
    workManager: Provider<WorkManager>,
    @Assisted savedStateHandle: SavedStateHandle,
) : AbstractViewModel<MessageListEvent, MessageListViewModel.Data, MessageListViewModel.State>(
    Data(),
    State.Init,
    applicationScope,
    workManager,
    savedStateHandle
) {

    override val loadedState: State = State.Loaded

    override fun dispatchEvent(event: MessageListEvent) {
        when (event) {
            MessageListEvent.Load -> startLoadingData()
        }
    }

    override fun loadData(): Flow<Result<Data>> {
        return messageRepository.getAllShown()
            .map { Data(it.toMessageListItems()) }
            .mapToResult()
    }

    override fun setErrorStateWith(errorMsg: Int) {
        updateState(State.Error(errorMsg))
    }

    data class Data(
        val messages: List<MessageListItem> = emptyList()
    ) : IData

    sealed class State : IState {
        object Init : State()
        object Loaded : State()
        data class Error(val error: Int) : State()
    }

    @AssistedFactory
    interface Factory : FactoryWithSavedStateHandle<MessageListViewModel>
}
