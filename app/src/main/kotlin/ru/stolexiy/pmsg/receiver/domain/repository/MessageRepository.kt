package ru.stolexiy.pmsg.receiver.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.stolexiy.pmsg.receiver.domain.model.DomainMessage

interface MessageRepository {
    fun getAll(): Flow<List<DomainMessage>>
    fun get(id: Long): Flow<DomainMessage?>
    fun getAllByTask(taskId: Long): Flow<List<DomainMessage>>
    suspend fun update(vararg subtasks: DomainMessage): Unit
    suspend fun delete(vararg subtasks: DomainMessage): Unit
    suspend fun insert(vararg subtasks: DomainMessage): List<Long>
    suspend fun deleteAll(): Unit
}