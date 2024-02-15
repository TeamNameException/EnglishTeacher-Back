package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.SubscribersRepository

class UnsubscribeUseCase(
    private val subscribersRepository: SubscribersRepository
) {

    suspend fun unsubscribe(idUser: Long, idSubscriber: Long) {
        subscribersRepository.unsubscribe(idUser, idSubscriber)
    }
}