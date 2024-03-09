package ru.teamnameexception.data.sources.favorite

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object FavoriteDataSourceImpl : FavoriteDataSource, Table("favorite") {

    private val idUser = FavoriteDataSourceImpl.varchar("id_user", 18)
    private val idLesson = FavoriteDataSourceImpl.varchar("id_lesson", 18)
    private val nameLesson = FavoriteDataSourceImpl.varchar("name_lesson", 18)

    override suspend fun addFavorite(userId: String, lessonId: String, nameLesson: String) {
        transaction {
            FavoriteDataSourceImpl.insert {
                it[idUser] = userId
                it[idLesson] = lessonId
                it[FavoriteDataSourceImpl.nameLesson] = nameLesson
            }
        }
    }

    override suspend fun deleteFavorite(userId: String, lessonId: String) {
        transaction {
            FavoriteDataSourceImpl.deleteWhere {
                (idUser.eq(userId)) and
                        (idLesson.eq(lessonId))
            }
        }
    }

    override suspend fun getFavorite(userId: String, limit: Int, offset: Int): List<String> {
        return transaction {
            FavoriteDataSourceImpl.select { idUser.eq(idUser) }.limit(limit, offset.toLong()).map {
                it[idLesson]
            }
        }
    }
}