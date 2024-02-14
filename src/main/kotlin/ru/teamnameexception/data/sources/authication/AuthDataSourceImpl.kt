package ru.teamnameexception.data.sources.authication

class AuthDataSourceImpl() : AuthDataSource {


    override suspend fun login(login: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun logout(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isLogged(token: String): Pair<Boolean, Long> {
        TODO("Not yet implemented")
    }


}