package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun login(idUser: String): String {
        return authRepository.login(idUser)
    }
}