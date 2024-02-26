package ru.teamnameexception.plugins.entities.lesson

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.WordEntity


@Serializable
data class LessonResponse(
    val id: String,
    val name: String,
    val description: String,
    val idCreator: String,
    val words: List<WordEntity>
)
