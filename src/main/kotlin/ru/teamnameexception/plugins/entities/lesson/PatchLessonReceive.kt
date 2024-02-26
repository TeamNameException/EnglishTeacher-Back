package ru.teamnameexception.plugins.entities.lesson

import kotlinx.serialization.Serializable

@Serializable
data class PatchLessonReceive(
    val token: String,
    val idLesson: String,
    val name: String,
    val description: String
)
