package ru.teamnameexception.plugins.entities.login

import kotlinx.serialization.Serializable


@Serializable
data class LoginReceive(
    val login: String,
    val password: String
)
