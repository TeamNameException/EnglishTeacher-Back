package ru.teamnameexception.data

import ru.teamnameexception.data.sources.subscribe.SubscribeDataSource
import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.SubscriberEntity
import ru.teamnameexception.domain.repositories.SubscribersRepository

class SubscribersRepositoryImpl(
    private val subscribeDataSource: SubscribeDataSource
) : SubscribersRepository {
    override suspend fun getSubscribers(idUser: String): List<SubscriberEntity> {
        TODO("Not yet implemented")
    }


    override suspend fun subscribe(idUser: String, subscriber: SubscriberEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun unsubscribe(idUser: String, idSubscriber: String) {
        TODO("Not yet implemented")
    }
}