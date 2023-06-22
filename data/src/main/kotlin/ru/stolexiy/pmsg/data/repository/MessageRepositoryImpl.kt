package ru.stolexiy.pmsg.data.repository

import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import ru.stolexiy.pmsg.common.di.CoroutineDispatcherNames
import ru.stolexiy.pmsg.data.common.QuerySnapshotUtils.mapToDomainObject
import ru.stolexiy.pmsg.data.common.QuerySnapshotUtils.mapToDomainObjects
import ru.stolexiy.pmsg.data.model.RemoteMessage
import ru.stolexiy.pmsg.data.model.RemoteMessage.Companion.toRemoteMessage
import ru.stolexiy.pmsg.domain.model.DomainMessage
import ru.stolexiy.pmsg.domain.repository.MessageRepository
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class MessageRepositoryImpl @Inject constructor(
    @Named(CoroutineDispatcherNames.IO_DISPATCHER) private val ioDispatcher: CoroutineDispatcher,
    @Named(CoroutineDispatcherNames.DEFAULT_DISPATCHER) private val defaultDispatcher: CoroutineDispatcher
) : MessageRepository {

    private val collectionRef = Firebase.firestore.collection(RemoteMessage.COLLECTION)

    override fun getAll(): Flow<List<DomainMessage>> {
        return collectionRef.snapshots()
            .flowOn(ioDispatcher)
            .mapToDomainObjects(RemoteMessage::toDomainMessage)
            .flowOn(defaultDispatcher)
    }

    override fun get(id: String): Flow<DomainMessage?> {
        return collectionRef.document(id).snapshots()
            .flowOn(ioDispatcher)
            .mapToDomainObject(RemoteMessage::toDomainMessage)
            .flowOn(defaultDispatcher)
    }

    override suspend fun update(vararg messages: DomainMessage) {
        coroutineScope {
            withContext(defaultDispatcher) {
                messages.filter { it.id != null }
                    .map {
                        async(ioDispatcher) {
                            collectionRef.document(it.id!!)
                                .set(it.toRemoteMessage(), SetOptions.merge())
                                .await()
                        }
                    }.awaitAll()
            }
        }
    }

    override suspend fun delete(vararg messages: DomainMessage) {
        coroutineScope {
            withContext(defaultDispatcher) {
                messages.filter { it.id != null }
                    .map {
                        async(ioDispatcher) {
                            collectionRef.document(it.id!!)
                                .delete()
                                .await()
                        }
                    }.awaitAll()
            }
        }
    }

    override suspend fun insert(vararg messages: DomainMessage): List<String> {
        return coroutineScope {
            withContext(defaultDispatcher) {
                messages.map {
                    async(ioDispatcher) {
                        collectionRef.add(messages).await().id
                    }
                }.awaitAll()
            }
        }
    }

    override suspend fun deleteAll() {
        //TODO
    }

}
