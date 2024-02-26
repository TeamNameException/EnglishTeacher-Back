package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.repositories.LessonRepository

class CreateLessonUseCase(
    private val lessonRepository: LessonRepository
) {

    suspend fun createLesson(lesson: LessonEntity) {
        lessonRepository.createLesson(lesson)
    }
}