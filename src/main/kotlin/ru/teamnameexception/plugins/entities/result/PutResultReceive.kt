package ru.teamnameexception.plugins.entities.result

import kotlinx.serialization.Serializable


@Serializable
data class PutResultReceive(
    val token: String,
    val idLesson: String,
    val countCorrect: Int,
    val countWrong: Int,
    val time: Long
)
