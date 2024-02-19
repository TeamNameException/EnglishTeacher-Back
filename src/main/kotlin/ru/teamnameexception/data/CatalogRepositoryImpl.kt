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
        TODO("Not yet implemented")
    }

    override suspend fun getFavorite(userId: String): List<CatalogLessonEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(userId: String, lessonId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(userId: String, lessonId: String) {
        TODO("Not yet implemented")
    }
}