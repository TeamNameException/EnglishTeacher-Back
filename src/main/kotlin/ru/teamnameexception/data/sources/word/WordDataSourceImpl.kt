package ru.teamnameexception.data.sources.word

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import ru.teamnameexception.domain.entities.WordEntity
import java.util.*

object WordDataSourceImpl : WordDataSource, Table("word") {

    private val id = WordDataSourceImpl.varchar("id", 18)
    private val rus = WordDataSourceImpl.varchar("rus", 18)
    private val eng = WordDataSourceImpl.varchar("eng", 18)
    private val idLesson = WordDataSourceImpl.varchar("id_lesson", 18)

    override suspend fun getWords(idLesson: String): List<WordEntity> {
        return transaction {
            return@transaction WordDataSourceImpl.select { WordDataSourceImpl.idLesson.eq(idLesson) }
                .map {
                    WordEntity(
                        it[eng],
                        it[rus]
                    )
                }
        }
    }

    override suspend fun addWords(words: List<WordEntity>, idLesson: String) {
        transaction {
            for (word in words) {
                WordDataSourceImpl.insert {
                    it[id] = UUID.randomUUID().toString().substring(0..17)
                    it[rus] = word.russ
                    it[eng] = word.eng
                    it[WordDataSourceImpl.idLesson] = idLesson
                }
            }
        }
    }

    override suspend fun deleteWords(words: List<WordEntity>, idLesson: String) {
        transaction {
            for (word in words) {
                WordDataSourceImpl.deleteWhere {
                    rus.eq(word.russ) and eng.eq(word.eng) and WordDataSourceImpl.idLesson.eq(idLesson)
                }
            }
        }
    }

    override suspend fun deleteWords(idLesson: String) {
        transaction {
            WordDataSourceImpl.deleteWhere { WordDataSourceImpl.idLesson.eq(idLesson) }
        }
    }

}