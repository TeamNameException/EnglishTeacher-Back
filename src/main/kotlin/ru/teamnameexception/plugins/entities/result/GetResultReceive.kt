package ru.teamnameexception.plugins.entities.result

import kotlinx.serialization.Serializable

@Serializable
data class GetResultReceive(
    val token: String,
    val limit: Int,
    val offset: Int
)
