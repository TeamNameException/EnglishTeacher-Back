package ru.teamnameexception.plugins.entities.word

import kotlinx.serialization.Serializable

@Serializable
data class WordReceive(
    val idLesson: String
)
