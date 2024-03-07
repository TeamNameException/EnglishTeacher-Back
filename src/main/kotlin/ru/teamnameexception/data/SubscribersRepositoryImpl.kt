package ru.teamnameexception.data

import ru.teamnameexception.data.sources.subscribe.SubscribeDataSource
import ru.teamnameexception.domain.entities.SubscriberEntity
import ru.teamnameexception.domain.repositories.SubscribersRepository

class SubscribersRepositoryImpl(
    private val subscribeDataSource: SubscribeDataSource
) : SubscribersRepository {
    override suspend fun getSubscribers(idUser: String, limit: Int, offset: Int): List<SubscriberEntity> {
        return subscribeDataSource.getSubscribers(idUser, limit, offset)
    }

    override suspend fun subscribe(idUser: String, subscriber: SubscriberEntity) {
        subscribeDataSource.subscribe(idUser, subscriber)
    }

    override suspend fun unsubscribe(idUser: String, idSubscriber: String) {
        subscribeDataSource.unsubscribe(idUser, idSubscriber)
    }
}