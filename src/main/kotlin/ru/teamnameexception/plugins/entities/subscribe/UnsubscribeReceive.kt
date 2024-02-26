package ru.teamnameexception.plugins.entities.subscribe

import kotlinx.serialization.Serializable


@Serializable
data class UnsubscribeReceive(
    val token: String,
    val userId: String
)
