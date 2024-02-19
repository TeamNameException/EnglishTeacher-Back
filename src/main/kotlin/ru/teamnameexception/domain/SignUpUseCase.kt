package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.SignUpEntity
import ru.teamnameexception.domain.repositories.UserRepository

class SignUpUseCase(
    private val userRepository: UserRepository
) {

    suspend fun signUp(userEntity: SignUpEntity) {
        userRepository.createUser(userEntity)
    }
}