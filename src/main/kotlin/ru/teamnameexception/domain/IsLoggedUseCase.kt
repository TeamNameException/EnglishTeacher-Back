package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.AuthRepository

class IsLoggedUseCase (
    private val authRepository: AuthRepository
) {

    suspend fun isLogged(token: String): Pair<Boolean, Long> {
        return authRepository.isLogged(token)
    }
}