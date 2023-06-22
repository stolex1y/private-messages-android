package ru.stolexiy.pmsg.data.common

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object QuerySnapshotUtils {
    inline fun <reified R : Any, D> QuerySnapshot.mapToDomainObjects(
        toDomain: R.(id: String) -> D
    ): List<D> {
        return documents.mapNotNull {
            it.toObject<R>()?.toDomain(it.id)
        }
    }

    inline fun <reified R : Any, D> Flow<QuerySnapshot>.mapToDomainObjects(
        crossinline toDomain: R.(id: String) -> D
    ): Flow<List<D>> {
        return map {
            it.mapToDomainObjects(toDomain)
        }
    }

    inline fun <reified R : Any, D> Flow<DocumentSnapshot>.mapToDomainObject(
        crossinline toDomain: R.(id: String) -> D
    ): Flow<D?> {
        return map {
            it.toObject<R>()?.toDomain(it.id)
        }
    }
}
