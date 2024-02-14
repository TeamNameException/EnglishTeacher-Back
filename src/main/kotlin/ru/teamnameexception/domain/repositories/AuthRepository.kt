package ru.teamnameexception.domain.repositories

interface AuthRepository {

    suspend fun login(login: String, pass: String): String

    suspend fun logout(token: String)

    suspend fun isLogged(token: String): Pair<Boolean, Long>

}