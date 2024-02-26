package ru.teamnameexception.data

import ru.teamnameexception.data.sources.catalog.CatalogDataSource
import ru.teamnameexception.data.sources.favorite.FavoriteDataSource
import ru.teamnameexception.domain.repositories.CatalogRepository
import ru.teamnameexception.domain.entities.CatalogLessonEntity

class CatalogRepositoryImpl(
    private val catalogDataSource : CatalogDataSource,
    private val favoriteDataSource: FavoriteDataSource
) : CatalogRepository {
    override suspend fun getCatalog(): List<CatalogLessonEntity> {
        return catalogDataSource.getCatalog()
    }

    override suspend fun getCatalogFromSub(userId: String): List<CatalogLessonEntity> {
        return catalogDataSource.getCatalogFromSub(userId)
    }

    override suspend fun getFavorite(userId: String): List<CatalogLessonEntity> {
        return favoriteDataSource.getFavorite(userId)
    }

    override suspend fun addFavorite(userId: String, lessonId: String) {
        val lessonName = catalogDataSource.getLesson(lessonId).name
        favoriteDataSource.addFavorite(userId, lessonId, lessonName)
    }

    override suspend fun deleteFavorite(userId: String, lessonId: String) {
        favoriteDataSource.deleteFavorite(userId, lessonId)
    }
}