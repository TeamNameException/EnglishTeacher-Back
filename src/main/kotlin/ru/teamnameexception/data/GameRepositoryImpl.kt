package ru.teamnameexception.data

import ru.teamnameexception.data.sources.game.GameDataSource
import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.ResultEntity
import ru.teamnameexception.domain.entities.WordEntity
import ru.teamnameexception.domain.repositories.GameRepository

class GameRepositoryImpl(
    private val gameDataSource: GameDataSource
) : GameRepository {
    override suspend fun getWords(idLesson: Long): List<WordEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getLesson(idLesson: Long): LessonEntity {
        TODO("Not yet implemented")
    }

    override suspend fun setResult(result: ResultEntity) {
        TODO("Not yet implemented")
    }
}