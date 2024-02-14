package ru.teamnameexception.data

import ru.teamnameexception.data.sources.catalog.CatalogDataSource
import ru.teamnameexception.domain.repositories.CatalogRepository
import ru.teamnameexception.domain.entities.CatalogLessonEntity

class CatalogRepositoryImpl(
    private val catalogDataSource : CatalogDataSource
) : CatalogRepository {
    override suspend fun getCatalog(): List<CatalogLessonEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavorite(userId: Long): List<CatalogLessonEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(userId: Long, lessonId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(userId: Long, lessonId: Long) {
        TODO("Not yet implemented")
    }
}