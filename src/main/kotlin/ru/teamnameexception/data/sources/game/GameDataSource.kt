package ru.teamnameexception.data.sources.game

import ru.teamnameexception.domain.entities.ResultEntity

interface GameDataSource {

    suspend fun setResult(result: ResultEntity)

    suspend fun getResults(idUser: String) : List<ResultEntity>
}