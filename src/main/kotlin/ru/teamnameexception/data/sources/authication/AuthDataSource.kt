package ru.teamnameexception.data.sources.authication

interface AuthDataSource {

    suspend fun login(idUser: String): String

    suspend fun logout(token: String)

    suspend fun isLogged(token: String): Pair<Boolean, String>




}