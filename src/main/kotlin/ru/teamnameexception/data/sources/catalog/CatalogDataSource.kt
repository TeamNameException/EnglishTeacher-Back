package ru.teamnameexception.data.sources.catalog

import ru.teamnameexception.domain.entities.CatalogLessonEntity
import ru.teamnameexception.domain.entities.LessonEntity

interface CatalogDataSource {

    suspend fun getCatalog(): List<CatalogLessonEntity>

    suspend fun getCatalogFromSub(userId: String) : List<CatalogLessonEntity>

    suspend fun getLesson(idLesson: String): LessonEntity

    suspend fun createLesson(newLesson: LessonEntity)

    suspend fun redactLesson(lesson: LessonEntity)

    suspend fun deleteLesson(idLesson: String)

}