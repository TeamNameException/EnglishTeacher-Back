package ru.teamnameexception.plugins.entities.login

import kotlinx.serialization.Serializable


@Serializable
data class LoginResponse(
    val token: String
)