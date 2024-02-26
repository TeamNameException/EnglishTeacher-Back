package ru.teamnameexception.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class CatalogLessonEntity(
    val id: String,
    val name: String
)
