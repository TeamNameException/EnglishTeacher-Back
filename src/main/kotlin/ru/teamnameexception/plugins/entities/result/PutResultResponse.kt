package ru.teamnameexception.plugins.entities.result

import kotlinx.serialization.Serializable


@Serializable
data class PutResultResponse(
    val id: String,
    val idLesson: String,
    val idUser: String,
    val time: Long,
    val countCorrect: Int,
    val countWrong: Int
)
