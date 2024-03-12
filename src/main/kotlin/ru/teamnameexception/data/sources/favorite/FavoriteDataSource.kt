package ru.teamnameexception.data.sources.favorite

import ru.teamnameexception.domain.entities.CatalogLessonEntity

interface FavoriteDataSource {

    suspend fun addFavorite(userId: String, lessonId: String, nameLesson : String)

    suspend fun deleteFavorite(userId: String, lessonId: String)

    suspend fun getFavorite(userId: String, limit: Int, offset: Int) : List<String>

    suspend fun checkFavorite(userId: String, lessons: List<CatalogLessonEntity>) : List<CatalogLessonEntity>
}