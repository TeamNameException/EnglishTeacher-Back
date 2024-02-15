package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.UserEntity
import ru.teamnameexception.domain.repositories.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) {

    suspend fun getUser(id: Long) : UserEntity {
        return userRepository.getUser(id)
    }

}