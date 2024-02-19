package ru.teamnameexception.data

import ru.teamnameexception.data.sources.catalog.CatalogDataSource
import ru.teamnameexception.data.sources.game.GameDataSource
import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.ResultEntity
import ru.teamnameexception.domain.entities.WordEntity
import ru.teamnameexception.domain.repositories.GameRepository

class GameRepositoryImpl(
    private val gameDataSource: GameDataSource,
    private val catalogDataSource: CatalogDataSource
) : GameRepository {
    override suspend fun getWords(idLesson: String): List<WordEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getLesson(idLesson: String): LessonEntity {
        TODO("Not yet implemented")
    }

    override suspend fun setResult(result: ResultEntity) {
        TODO("Not yet implemented")
    }
}