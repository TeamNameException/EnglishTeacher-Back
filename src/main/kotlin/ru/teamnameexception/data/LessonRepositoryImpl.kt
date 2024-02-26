package ru.teamnameexception.data

import ru.teamnameexception.data.sources.catalog.CatalogDataSource
import ru.teamnameexception.data.sources.word.WordDataSource
import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.WordEntity
import ru.teamnameexception.domain.repositories.LessonRepository

class LessonRepositoryImpl(
    private val catalogDataSource: CatalogDataSource,
    private val wordDataSource: WordDataSource
) : LessonRepository {
    override suspend fun createLesson(newLesson: LessonEntity) {
        catalogDataSource.createLesson(newLesson)
    }

    override suspend fun redactLesson(lesson: LessonEntity) {
        catalogDataSource.redactLesson(lesson)
    }

    override suspend fun deleteWord(words: List<WordEntity>, idLesson: String) {
        wordDataSource.deleteWords(words, idLesson)
    }

    override suspend fun addWord(words: List<WordEntity>, idLesson: String) {
        wordDataSource.addWords(words, idLesson)
    }

    override suspend fun deleteLesson(idLesson: String) {
        catalogDataSource.deleteLesson(idLesson)
        wordDataSource.deleteWords(idLesson)
    }


}