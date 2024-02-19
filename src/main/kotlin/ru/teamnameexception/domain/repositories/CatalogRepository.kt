package ru.teamnameexception.domain.repositories

import ru.teamnameexception.domain.entities.CatalogLessonEntity

interface CatalogRepository {


    suspend fun getCatalog(): List<CatalogLessonEntity>

    suspend fun getFavorite(userId: String): List<CatalogLessonEntity>

    suspend fun addFavorite(userId: String, lessonId: String)

    suspend fun deleteFavorite(userId: String, lessonId: String)


}