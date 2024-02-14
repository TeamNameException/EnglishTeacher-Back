package ru.teamnameexception.data

import ru.teamnameexception.data.sources.authication.AuthDataSource
import ru.teamnameexception.domain.repositories.AuthRepository

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource
) : AuthRepository {

    override suspend fun login(login: String, pass: String): String {
        return authDataSource.login(login, pass)
    }

    override suspend fun logout(token: String) {
        authDataSource.logout(token)
    }

    override suspend fun isLogged(token: String): Pair<Boolean, Long> {
        return authDataSource.isLogged(token)
    }


}