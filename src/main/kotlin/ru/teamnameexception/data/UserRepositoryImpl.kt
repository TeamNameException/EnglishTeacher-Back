package ru.teamnameexception.data

import ru.teamnameexception.data.sources.user.UserDataSource
import ru.teamnameexception.domain.entities.SignUpEntity
import ru.teamnameexception.domain.entities.UserEntity
import ru.teamnameexception.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUser(id: String): UserEntity {
        return userDataSource.getUser(id)
    }

    override suspend fun getUserId(login: String, password: String): String {
        return userDataSource.getUserId(login, password)
    }


    override suspend fun renameUser(id: String, newName: String) {
        userDataSource.renameUser(id, newName)
    }

    override suspend fun createUser(newUser: SignUpEntity) {
        userDataSource.createUser(newUser)
    }
}