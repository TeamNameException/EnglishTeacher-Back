package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.LessonRepository

class DeleteLessonUseCase(
    private val lessonRepository: LessonRepository
) {

    suspend fun deleteLesson(idLesson: String) {
        lessonRepository.deleteLesson(idLesson)
    }
}