package ru.teamnameexception.data

import ru.teamnameexception.data.sources.user.UserDataSource
import ru.teamnameexception.domain.entities.UserEntity
import ru.teamnameexception.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUser(id: Long): UserEntity {
        TODO("Not yet implemented")
    }


    override suspend fun renameUser(id: Long, newName: String) {
        TODO("Not yet implemented")
    }
}