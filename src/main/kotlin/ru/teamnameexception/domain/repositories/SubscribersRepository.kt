package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.SubscriberEntity

interface SubscribersRepository {

    suspend fun getSubscribers(idUser: Long) : List<SubscriberEntity>

    suspend fun getSubscriberLesson(id: Long) : List<LessonEntity>

    suspend fun subscribe(idUser: Long, idSubscriber: Long)

    suspend fun unsubscribe(idUser: Long, idSubscriber: Long)

}