package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.SubscriberEntity

interface SubscribersRepository {

    suspend fun getSubscribers(idUser: String, limit: Int, offset: Int): List<SubscriberEntity>

    suspend fun subscribe(idUser: String, subscriber: SubscriberEntity)

    suspend fun unsubscribe(idUser: String, idSubscriber: String)


}