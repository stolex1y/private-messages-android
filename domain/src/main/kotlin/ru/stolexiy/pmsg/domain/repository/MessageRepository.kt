package ru.stolexiy.pmsg.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.stolexiy.pmsg.domain.model.DomainMessage

interface MessageRepository {
    fun getAll(): Flow<List<DomainMessage>>
    fun get(id: String): Flow<DomainMessage?>
    fun getAllShown(): Flow<List<DomainMessage>>
    suspend fun update(vararg messages: DomainMessage): Unit
    suspend fun delete(vararg messages: DomainMessage): Unit
    suspend fun insert(vararg messages: DomainMessage): List<String>
    suspend fun deleteAll(): Unit
}
