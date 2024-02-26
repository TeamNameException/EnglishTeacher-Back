package ru.teamnameexception.plugins.entities.favorite

import kotlinx.serialization.Serializable


@Serializable
data class FavoriteReceive(
    val token : String
)