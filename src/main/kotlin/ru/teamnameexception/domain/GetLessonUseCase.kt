package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.repositories.GameRepository

class GetLessonUseCase (
    private val gameRepository: GameRepository
) {
    suspend fun getLesson(id: String) : LessonEntity {
        return gameRepository.getLesson(id)
    }
}