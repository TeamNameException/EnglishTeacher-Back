package ru.teamnameexception.data.sources.word

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import ru.teamnameexception.domain.entities.WordEntity

object WordDataSourceImpl : WordDataSource, Table("word") {

    private val rus = WordDataSourceImpl.varchar("rus", 18)
    private val eng = WordDataSourceImpl.varchar("eng", 18)
    private val idLesson = WordDataSourceImpl.varchar("id_lesson", 18)

    override suspend fun getWords(idLesson: String): List<WordEntity> {
        return transaction {
            WordDataSourceImpl.select { WordDataSourceImpl.idLesson.eq(idLesson) }
                .map {
                    WordEntity(
                        it[eng],
                        it[rus]
                    )
                }
        }
    }

}