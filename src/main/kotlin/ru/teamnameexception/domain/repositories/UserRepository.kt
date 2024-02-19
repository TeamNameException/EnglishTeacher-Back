package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.SignUpEntity
import ru.teamnameexception.domain.entities.UserEntity

interface UserRepository {

    suspend fun getUser(id: String) : UserEntity

    suspend fun renameUser(id: String, newName: String)

    suspend fun createUser(newUser: SignUpEntity)

    suspend fun getUserId(login: String, password: String) : String

}