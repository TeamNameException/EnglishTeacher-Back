package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.ResultEntity
import ru.teamnameexception.domain.repositories.GameRepository

class SetResultUseCase(
    private val gameRepository: GameRepository
) {

    suspend fun setResult(result: ResultEntity) {
        gameRepository.setResult(result)
    }
}