package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.CatalogLessonEntity
import ru.teamnameexception.domain.repositories.CatalogRepository

class GetCatalogFromSubUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend fun getCatalogFromSub(userId: String): List<CatalogLessonEntity> {
        return catalogRepository.getCatalogFromSub(userId)
    }
}