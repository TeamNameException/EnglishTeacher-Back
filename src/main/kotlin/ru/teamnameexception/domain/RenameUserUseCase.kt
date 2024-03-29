package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.UserRepository

class RenameUserUseCase(
    private val userRepository: UserRepository
) {

    suspend fun renameUser(id: String, newName: String) {
        userRepository.renameUser(id, newName)
    }
}