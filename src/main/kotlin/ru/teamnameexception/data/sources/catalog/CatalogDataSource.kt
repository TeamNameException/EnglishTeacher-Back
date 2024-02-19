package ru.teamnameexception.data.sources.catalog

import ru.teamnameexception.domain.entities.CatalogLessonEntity
import ru.teamnameexception.domain.entities.LessonEntity

interface CatalogDataSource {

    suspend fun getCatalog(): List<CatalogLessonEntity>

    suspend fun getLesson(idLesson: String): LessonEntity

}