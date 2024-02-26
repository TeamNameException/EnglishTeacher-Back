package ru.teamnameexception.plugins.entities.lesson

import kotlinx.serialization.Serializable

@Serializable
data class DeleteLessonReceive(
    val token: String,
    val idLesson: String
)
