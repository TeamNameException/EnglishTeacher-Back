package ru.teamnameexception.domain.entities

data class ResultEntity(
    val idLesson: String,
    val idUser: String,
    val time: Long,
    val countCorrect: Int,
    val countWrong: Int
)
