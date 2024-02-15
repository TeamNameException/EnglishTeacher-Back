package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.CatalogRepository

class DeleteFavoriteUseCase(
    private val catalogRepository: CatalogRepository
) {
    suspend fun deleteFavorite(userId: Long, lessonId: Long) {
        catalogRepository.deleteFavorite(userId, lessonId)
    }
}