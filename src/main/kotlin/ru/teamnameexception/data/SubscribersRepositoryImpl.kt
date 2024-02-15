package ru.teamnameexception.data

import ru.teamnameexception.data.sources.subscribe.SubscribeDataSource
import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.SubscriberEntity
import ru.teamnameexception.domain.repositories.SubscribersRepository

class SubscribersRepositoryImpl(
    private val subscribeDataSource: SubscribeDataSource
) : SubscribersRepository {
    override suspend fun getSubscribers(idUser: Long): List<SubscriberEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getSubscriberLesson(id: Long): List<LessonEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun subscribe(idUser: Long, idSubscriber: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun unsubscribe(idUser: Long, idSubscriber: Long) {
        TODO("Not yet implemented")
    }
}