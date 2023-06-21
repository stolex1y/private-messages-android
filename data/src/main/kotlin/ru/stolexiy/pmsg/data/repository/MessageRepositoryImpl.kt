package ru.stolexiy.pmsg.data.repository

import kotlinx.coroutines.flow.Flow
import ru.stolexiy.pmsg.domain.model.DomainMessage
import ru.stolexiy.pmsg.domain.repository.MessageRepository

class MessageRepositoryImpl(

) : MessageRepository {
    override fun getAll(): Flow<List<DomainMessage>> {
        TODO("Not yet implemented")
    }

    override fun get(id: Long): Flow<DomainMessage?> {
        TODO("Not yet implemented")
    }

    override fun getAllByTask(taskId: Long): Flow<List<DomainMessage>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(vararg subtasks: DomainMessage) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(vararg subtasks: DomainMessage) {
        TODO("Not yet implemented")
    }

    override suspend fun insert(vararg subtasks: DomainMessage): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

}
