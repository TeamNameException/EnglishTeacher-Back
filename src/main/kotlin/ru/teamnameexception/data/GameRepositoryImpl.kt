package ru.teamnameexception.data

import ru.teamnameexception.data.sources.catalog.CatalogDataSource
import ru.teamnameexception.data.sources.game.GameDataSource
import ru.teamnameexception.data.sources.word.WordDataSource
import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.entities.ResultEntity
import ru.teamnameexception.domain.entities.WordEntity
import ru.teamnameexception.domain.repositories.GameRepository

class GameRepositoryImpl(
    private val gameDataSource: GameDataSource,
    private val catalogDataSource: CatalogDataSource,
    private val wordDataSource: WordDataSource
) : GameRepository {
    override suspend fun getWords(idLesson: String): List<WordEntity> {
        return wordDataSource.getWords(idLesson)
    }

    override suspend fun getLesson(idLesson: String): LessonEntity {
        return catalogDataSource.getLesson(idLesson)
    }

    override suspend fun setResult(result: ResultEntity) {
        gameDataSource.setResult(result)
    }

    override suspend fun getResults(idUser: String): List<ResultEntity> {
        return gameDataSource.getResults(idUser)
    }

}