package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.WordEntity
import ru.teamnameexception.domain.repositories.LessonRepository

class DeleteWordUseCase(
    private val lessonRepository: LessonRepository
) {

    suspend fun deleteWords(words: List<WordEntity>, idLesson: String) {
        lessonRepository.deleteWord(words, idLesson)
    }
}