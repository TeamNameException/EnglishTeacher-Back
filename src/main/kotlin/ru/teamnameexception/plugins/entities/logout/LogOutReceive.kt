package ru.teamnameexception.plugins.entities.logout

import kotlinx.serialization.Serializable


@Serializable
data class LogOutReceive(
    val token: String
)