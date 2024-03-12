package ru.teamnameexception.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class CatalogLessonEntity(
    val id: String,
    val name: String,
    val description: String,
    val idCreator: String,
    val isFavorite: Boolean = false
) {


    fun setFavorite(flag: Boolean): CatalogLessonEntity {
        return CatalogLessonEntity(
            id,
            name,
            description,
            idCreator,
            flag
        )
    }
}
