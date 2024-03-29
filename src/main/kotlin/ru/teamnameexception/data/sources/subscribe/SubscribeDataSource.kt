package ru.teamnameexception.data.sources.subscribe

import ru.teamnameexception.domain.entities.SubscriberEntity

interface SubscribeDataSource {

    suspend fun getSubscribers(idUser: String, limit: Int, offset: Int): List<SubscriberEntity>

    suspend fun subscribe(idUser: String, subscriber: SubscriberEntity)

    suspend fun unsubscribe(idUser: String, idSubscriber: String)


}