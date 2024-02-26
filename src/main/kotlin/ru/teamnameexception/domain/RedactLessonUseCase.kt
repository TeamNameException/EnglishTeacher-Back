package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.repositories.LessonRepository

class RedactLessonUseCase(
    private val lessonRepository: LessonRepository
) {

    suspend fun redactLesson(lesson: LessonEntity) {
        lessonRepository.redactLesson(lesson)
    }
}