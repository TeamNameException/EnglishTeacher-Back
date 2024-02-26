package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.WordEntity
import ru.teamnameexception.domain.repositories.LessonRepository

class AddWordUseCase(
    private val lessonRepository: LessonRepository
) {

    suspend fun addWord(words: List<WordEntity>, idLesson: String) {
        lessonRepository.addWord(words, idLesson)
    }
}