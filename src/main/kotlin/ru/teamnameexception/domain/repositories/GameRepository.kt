package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.ResultEntity
import ru.teamnameexception.domain.entities.WordEntity

interface GameRepository {

    suspend fun getWords(idLesson: String) : List<WordEntity>

    suspend fun getLesson(idLesson: String) : LessonEntity

    suspend fun setResult(result: ResultEntity)

    suspend fun getResults(idUser: String) : List<ResultEntity>
}