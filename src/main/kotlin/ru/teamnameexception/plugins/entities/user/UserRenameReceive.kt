package ru.teamnameexception.plugins.entities.user

import kotlinx.serialization.Serializable


@Serializable
data class UserRenameReceive(
    val token: String,
    val newName: String
)
