package ru.teamnameexception.data.sources.word

import ru.teamnameexception.domain.entities.WordEntity

interface WordDataSource {


    suspend fun getWords(idLesson: String) : List<WordEntity>
}