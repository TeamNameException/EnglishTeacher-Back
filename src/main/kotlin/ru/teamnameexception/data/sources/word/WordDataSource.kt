package ru.teamnameexception.data.sources.word

import ru.teamnameexception.domain.entities.WordEntity

interface WordDataSource {


    suspend fun getWords(idLesson: String) : List<WordEntity>

    suspend fun addWords(words: List<WordEntity>,  idLesson: String)

    suspend fun deleteWords(words: List<WordEntity>, idLesson: String)

    suspend fun deleteWords(idLesson: String)
}