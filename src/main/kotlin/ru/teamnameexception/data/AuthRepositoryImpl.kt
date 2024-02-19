package ru.teamnameexception.data

import ru.teamnameexception.data.sources.authication.AuthDataSource
import ru.teamnameexception.domain.repositories.AuthRepository

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource
) : AuthRepository {

    override suspend fun login(idUser: String): String {
        return authDataSource.login(idUser)
    }

    override suspend fun logout(token: String) {
        authDataSource.logout(token)
    }

    override suspend fun isLogged(token: String): Pair<Boolean, String> {
        return authDataSource.isLogged(token)
    }


}