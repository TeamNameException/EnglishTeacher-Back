package ru.teamnameexception.plugins.entities.favorite

import kotlinx.serialization.Serializable


@Serializable
data class FavoriteReceive(
    val token : String,
    val limit: Int,
    val offset: Int
)