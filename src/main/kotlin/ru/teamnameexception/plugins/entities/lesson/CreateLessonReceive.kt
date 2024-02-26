package ru.teamnameexception.plugins.entities.lesson

import kotlinx.serialization.Serializable


@Serializable
data class CreateLessonReceive(
    val token: String,
    val name: String,
    val description: String
)
