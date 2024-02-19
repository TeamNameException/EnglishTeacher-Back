package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.CatalogRepository

class AddFavoriteUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend fun addFavorite(userId: String, lessonId: String) {
        catalogRepository.addFavorite(userId, lessonId)
    }
}