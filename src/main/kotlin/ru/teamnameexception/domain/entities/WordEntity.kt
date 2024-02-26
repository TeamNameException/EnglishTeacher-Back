package ru.teamnameexception.domain.entities

import kotlinx.serialization.Serializable


@Serializable
data class WordEntity(
    val eng: String,
    val russ: String
)