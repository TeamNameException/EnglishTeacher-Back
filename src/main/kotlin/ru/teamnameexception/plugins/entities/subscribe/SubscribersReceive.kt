package ru.teamnameexception.plugins.entities.subscribe

import kotlinx.serialization.Serializable


@Serializable
data class SubscribersReceive(
    val token: String
)
