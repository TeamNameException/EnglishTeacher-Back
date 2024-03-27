package ru.teamnameexception.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class CatalogLessonEntity(
    val id: String,
    val name: String,
    val description: String,
    val idCreator: String,
    val isFavorite: Boolean = false,
    val countWord: Int? = null,
) {


    fun setFavorite(flag: Boolean): CatalogLessonEntity {
        return CatalogLessonEntity(
            id,
            name,
            description,
            idCreator,
            flag,
            countWord
        )
    }

    fun setCountWord(countWord: Int): CatalogLessonEntity =
        CatalogLessonEntity(
            id,
            name,
            description,
            idCreator,
            isFavorite,
            countWord
        )
}
