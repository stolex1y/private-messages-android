package ru.stolexiy.pmsg.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.stolexiy.pmsg.data.repository.MessageRepositoryImpl
import ru.stolexiy.pmsg.domain.repository.MessageRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun messageRepository(i: MessageRepositoryImpl): MessageRepository
}
