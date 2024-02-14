package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.AuthRepository

class LogOutUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun logout(token: String) {
        authRepository.logout(token)
    }
}