package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.WordEntity

interface LessonRepository {

    suspend fun createLesson(newLesson: LessonEntity)

    suspend fun redactLesson(lesson: LessonEntity)

    suspend fun deleteWord(words: List<WordEntity>, idLesson: String)

    suspend fun addWord(words: List<WordEntity>, idLesson: String)

    suspend fun deleteLesson(idLesson: String)
}