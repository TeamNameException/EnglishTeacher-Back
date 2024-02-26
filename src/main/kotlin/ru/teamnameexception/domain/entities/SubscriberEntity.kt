package ru.teamnameexception.domain.entities

import kotlinx.serialization.Serializable


@Serializable
data class SubscriberEntity(
    val idSubscriber: String,
    val nameSubscriber: String
)
