package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.CatalogRepository

class DeleteFavoriteUseCase(
    private val catalogRepository: CatalogRepository
) {
    suspend fun deleteFavorite(userId: String, lessonId: String) {
        catalogRepository.deleteFavorite(userId, lessonId)
    }
}