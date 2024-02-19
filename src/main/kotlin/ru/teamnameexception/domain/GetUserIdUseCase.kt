package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.UserRepository

class GetUserIdUseCase(
    private val userRepository: UserRepository
) {
    suspend fun getUserId(login: String, password: String): String {
        return userRepository.getUserId(login, password)
    }
}