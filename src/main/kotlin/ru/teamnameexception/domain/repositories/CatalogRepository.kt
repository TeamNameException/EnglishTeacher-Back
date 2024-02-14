package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.CatalogLessonEntity

interface CatalogRepository {


    suspend fun getCatalog(): List<CatalogLessonEntity>

    suspend fun getFavorite(userId: Long): List<CatalogLessonEntity>

    suspend fun addFavorite(userId: Long, lessonId: Long)

    suspend fun deleteFavorite(userId: Long, lessonId: Long)


}