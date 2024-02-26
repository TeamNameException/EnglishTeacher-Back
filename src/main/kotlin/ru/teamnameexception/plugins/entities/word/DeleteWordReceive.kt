package ru.teamnameexception.plugins.entities.word

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.WordEntity

@Serializable
data class DeleteWordReceive(
    val token: String,
    val idLesson: String,
    val words: List<WordEntity>
)
