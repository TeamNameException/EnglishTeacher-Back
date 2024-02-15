package ru.teamnameexception.domain

import ru.teamnameexception.domain.repositories.CatalogRepository

class AddFavoriteUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend fun addFavorite(userId: Long, lessonId: Long) {
        catalogRepository.addFavorite(userId, lessonId)
    }
}