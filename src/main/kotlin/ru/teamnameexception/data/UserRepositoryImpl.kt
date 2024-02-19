package ru.teamnameexception.data

import ru.teamnameexception.data.sources.user.UserDataSource
import ru.teamnameexception.domain.entities.SignUpEntity
import ru.teamnameexception.domain.entities.UserEntity
import ru.teamnameexception.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUser(id: String): UserEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getUserId(login: String, password: String): String {
        TODO("Not yet implemented")
    }


    override suspend fun renameUser(id: String, newName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun createUser(newUser: SignUpEntity) {
        TODO("Not yet implemented")
    }
}