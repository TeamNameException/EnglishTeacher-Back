package ru.teamnameexception.data.sources.user

import ru.teamnameexception.domain.entities.SignUpEntity
import ru.teamnameexception.domain.entities.UserEntity

interface UserDataSource {

    suspend fun getUser(id: String): UserEntity

    suspend fun getUserId(login: String, password: String): String

    suspend fun renameUser(id: String, newName: String)

    suspend fun createUser(newUser: SignUpEntity)

}