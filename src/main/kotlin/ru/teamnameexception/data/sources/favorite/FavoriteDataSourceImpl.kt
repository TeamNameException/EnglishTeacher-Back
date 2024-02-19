package ru.teamnameexception.data.sources.favorite

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import ru.teamnameexception.domain.entities.CatalogLessonEntity

object FavoriteDataSourceImpl : FavoriteDataSource, Table("favorite") {

    private val idUser = FavoriteDataSourceImpl.varchar("id_user", 18)
    private val idLesson = FavoriteDataSourceImpl.varchar("id_lesson", 18)
    private val nameLesson = FavoriteDataSourceImpl.varchar("name_lesson", 18)

    override suspend fun addFavorite(userId: String, lessonId: String, nameLesson : String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(userId: String, lessonId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getFavorite(userId: String): List<CatalogLessonEntity> {
        return transaction {
            FavoriteDataSourceImpl.select { idUser.eq(idUser) }.map {
                CatalogLessonEntity(
                    it[idLesson],
                    it[nameLesson]
                )
            }
        }
    }
}