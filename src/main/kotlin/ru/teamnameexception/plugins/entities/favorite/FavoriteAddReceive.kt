package ru.teamnameexception.plugins.entities.favorite

import kotlinx.serialization.Serializable


@Serializable
data class FavoriteAddReceive(
    val token: String,
    val lessonId: String
)
