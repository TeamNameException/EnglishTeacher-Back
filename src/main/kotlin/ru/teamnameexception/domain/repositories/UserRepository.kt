package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.UserEntity

interface UserRepository {

    suspend fun getUser(id: Long) : UserEntity

    suspend fun renameUser(id: Long, newName: String)

}