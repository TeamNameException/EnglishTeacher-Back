package ru.teamnameexception.plugins.entities.signup

import kotlinx.serialization.Serializable


@Serializable
data class SignUpReceive(
    val name: String,
    val login: String,
    val password: String
)
