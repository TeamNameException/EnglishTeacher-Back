package ru.teamnameexception.data.sources.game

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import ru.teamnameexception.domain.entities.ResultEntity

object GameDataSourceImpl : GameDataSource, Table("result") {

    private val id = GameDataSourceImpl.varchar("id", 18)
    private val idLesson = GameDataSourceImpl.varchar("id_lesson", 18)
    private val idUser = GameDataSourceImpl.varchar("id_user", 18)
    private val time = GameDataSourceImpl.integer("time")
    private val countCorrect = GameDataSourceImpl.integer("count_correct")
    private val countWrong = GameDataSourceImpl.integer("count_wrong")


    override suspend fun setResult(result: ResultEntity) {
        transaction {
            GameDataSourceImpl.insert {
                it[id] = result.id
                it[idLesson] = result.idLesson
                it[idUser] = result.idUser
                it[time] = result.time.toInt()
                it[countCorrect] = result.countCorrect
                it[countWrong] = result.countWrong
            }
        }
    }

    override suspend fun getResults(idUser: String, limit: Int, offset: Int): List<ResultEntity> {
        return transaction {
            GameDataSourceImpl.select {
                GameDataSourceImpl.idUser.eq(idUser)
            }.limit(limit, offset.toLong()).map{
                ResultEntity(
                    it[GameDataSourceImpl.id],
                    it[idLesson],
                    it[GameDataSourceImpl.idUser],
                    it[time].toLong(),
                    it[countCorrect],
                    it[countWrong]
                )
            }
        }
    }


}