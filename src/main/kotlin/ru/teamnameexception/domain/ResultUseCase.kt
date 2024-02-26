package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.ResultEntity
import ru.teamnameexception.domain.repositories.GameRepository

class ResultUseCase(
    private val gameRepository: GameRepository
) {

    suspend fun setResult(result: ResultEntity) {
        gameRepository.setResult(result)
    }

    suspend fun getResult(idUser: String) : List<ResultEntity> {
        return gameRepository.getResults(idUser)
    }
}