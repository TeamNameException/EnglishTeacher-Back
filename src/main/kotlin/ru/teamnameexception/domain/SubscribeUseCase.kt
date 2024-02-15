package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.SubscribersRepository

class SubscribeUseCase(
    private val subscribersRepository: SubscribersRepository
) {

    suspend fun subscribe(idUser: Long, idSubscriber: Long) {
        subscribersRepository.subscribe(idUser, idSubscriber)
    }
}