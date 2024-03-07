package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.CatalogLessonEntity
import ru.teamnameexception.domain.repositories.CatalogRepository

class GetCatalogUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend fun getCatalog(limit: Int, offset: Int): List<CatalogLessonEntity> {
        return catalogRepository.getCatalog(limit, offset)
    }

    suspend fun getFavorite(userId: String, limit: Int, offset: Int): List<CatalogLessonEntity> {
        return catalogRepository.getFavorite(userId, limit, offset)
    }
}