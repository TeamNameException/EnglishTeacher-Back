package ru.teamnameexception.plugins.entities.word

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.WordEntity

@Serializable
data class AddWordReceive(
    val token : String,
    val words: List<WordEntity>,
    val idLesson: String
)
