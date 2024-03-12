package ru.teamnameexception.data

import ru.teamnameexception.data.sources.catalog.CatalogDataSource
import ru.teamnameexception.data.sources.favorite.FavoriteDataSource
import ru.teamnameexception.domain.repositories.CatalogRepository
import ru.teamnameexception.domain.entities.CatalogLessonEntity

class CatalogRepositoryImpl(
    private val catalogDataSource: CatalogDataSource,
    private val favoriteDataSource: FavoriteDataSource
) : CatalogRepository {
    override suspend fun getCatalog(limit: Int, offset: Int, userId: String): List<CatalogLessonEntity> {
        val catalog = catalogDataSource.getCatalog(limit, offset)
        return favoriteDataSource.checkFavorite(userId, catalog)
    }

    override suspend fun getCatalogFromSub(userId: String, limit: Int, offset: Int): List<CatalogLessonEntity> {
        return catalogDataSource.getCatalogFromSub(userId, limit, offset)
    }

    override suspend fun getFavorite(userId: String, limit: Int, offset: Int): List<CatalogLessonEntity> {
        val idLessonsList = favoriteDataSource.getFavorite(userId, limit, offset)
        val lessons = catalogDataSource.getLessons(idLessonsList).map {
            it.setFavorite(true)
        }
        return lessons
    }

    override suspend fun addFavorite(userId: String, lessonId: String) {
        val lessonName = catalogDataSource.getLesson(lessonId).name
        favoriteDataSource.addFavorite(userId, lessonId, lessonName)
    }

    override suspend fun deleteFavorite(userId: String, lessonId: String) {
        favoriteDataSource.deleteFavorite(userId, lessonId)
    }
}