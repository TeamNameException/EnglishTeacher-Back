package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.SubscriberEntity
import ru.teamnameexception.domain.repositories.SubscribersRepository

class GetSubscribersUseCase(
    private val subscribersRepository: SubscribersRepository
) {

    suspend fun getSubscribers(id: String) : List<SubscriberEntity> {
        return subscribersRepository.getSubscribers(id)
    }
}