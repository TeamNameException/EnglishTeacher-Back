package ru.teamnameexception.plugins.entities.lesson

import kotlinx.serialization.Serializable


@Serializable
data class CreateLessonResponse(
    val idLesson: String
)
