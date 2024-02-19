package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.WordEntity
import ru.teamnameexception.domain.repositories.GameRepository

class GetWordsUseCase (
    private val gameRepository: GameRepository
) {

    suspend fun getWords(lessonId: String) : List<WordEntity> {
        return gameRepository.getWords(lessonId)
    }
}