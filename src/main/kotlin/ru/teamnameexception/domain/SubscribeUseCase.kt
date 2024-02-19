package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.SubscriberEntity
import ru.teamnameexception.domain.repositories.SubscribersRepository

class SubscribeUseCase(
    private val subscribersRepository: SubscribersRepository
) {

    suspend fun subscribe(idUser: String, subscriber: SubscriberEntity) {
        subscribersRepository.subscribe(idUser, subscriber)
    }
}