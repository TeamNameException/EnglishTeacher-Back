package ru.teamnameexception.plugins.entities.subscribe

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.SubscriberEntity


@Serializable
data class SubscribersResponse(
    val subscribers : List<SubscriberEntity>
)
