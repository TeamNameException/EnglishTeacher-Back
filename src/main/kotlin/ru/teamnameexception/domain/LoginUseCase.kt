package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun login(login: String, password: String): String {
        return authRepository.login(login, password)
    }
}