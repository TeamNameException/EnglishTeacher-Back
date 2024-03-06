package ru.teamnameexception.plugins.entities.user

import kotlinx.serialization.Serializable


@Serializable
data class UserResponse(
    val id: String,
    val name: String,
    val login: String
)
