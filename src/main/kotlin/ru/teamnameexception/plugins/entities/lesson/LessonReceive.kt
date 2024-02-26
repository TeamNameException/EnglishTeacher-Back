package ru.teamnameexception.plugins.entities.lesson

import kotlinx.serialization.Serializable


@Serializable
data class LessonReceive(
    val lessonId: String
)
