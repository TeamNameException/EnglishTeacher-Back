package ru.teamnameexception.domain.entities

data class ResultEntity(
    val idLesson: Long,
    val idUser: Long,
    val time: Long,
    val countCorrect: Int,
    val countWrong: Int
)
