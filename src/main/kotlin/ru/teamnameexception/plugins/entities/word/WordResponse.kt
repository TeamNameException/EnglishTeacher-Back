package ru.teamnameexception.plugins.entities.word

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.WordEntity


@Serializable
data class WordResponse(
    val words: List<WordEntity>
)
