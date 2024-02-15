package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.CatalogLessonEntity
import ru.teamnameexception.domain.repositories.CatalogRepository

class GetCatalogUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend fun getCatalog(): List<CatalogLessonEntity> {
        return catalogRepository.getCatalog()
    }

    suspend fun getFavorite(userId: Long): List<CatalogLessonEntity> {
        return catalogRepository.getFavorite(userId)
    }
}