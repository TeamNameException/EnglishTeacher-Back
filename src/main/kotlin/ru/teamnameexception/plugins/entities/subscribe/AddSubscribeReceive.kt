package ru.teamnameexception.plugins.entities.subscribe

import kotlinx.serialization.Serializable


@Serializable
data class AddSubscribeReceive(
    val token: String,
    val userId: String
)
