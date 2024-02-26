package ru.teamnameexception.data.sources.catalog

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import ru.teamnameexception.domain.entities.CatalogLessonEntity
import ru.teamnameexception.domain.entities.LessonEntity

object CatalogDataSourceImpl : CatalogDataSource, Table("lesson") {

    private val id = CatalogDataSourceImpl.varchar("id", 18)
    private val name = CatalogDataSourceImpl.varchar("name", 18)
    private val description = CatalogDataSourceImpl.varchar("description", 50)
    private val idCreator = CatalogDataSourceImpl.varchar("id_creator", 18)
    override suspend fun getCatalog(): List<CatalogLessonEntity> {
        return transaction {
            CatalogDataSourceImpl.selectAll().map {
                CatalogLessonEntity(
                    it[CatalogDataSourceImpl.id],
                    it[name]
                )
            }
        }
    }

    override suspend fun getCatalogFromSub(userId: String): List<CatalogLessonEntity> {
        return transaction {
            return@transaction CatalogDataSourceImpl.select {
                idCreator.eq(userId)
            }.map {
                CatalogLessonEntity(
                    it[CatalogDataSourceImpl.id],
                    it[name]
                )
            }
        }
    }

    override suspend fun getLesson(idLesson: String): LessonEntity {

        val databaseEntity = transaction {
            return@transaction CatalogDataSourceImpl.select {
                CatalogDataSourceImpl.id.eq(idLesson)
            }.single()
        }

        return LessonEntity(
            idLesson,
            databaseEntity[name],
            databaseEntity[description],
            databaseEntity[idCreator]
        )
    }

    override suspend fun createLesson(newLesson: LessonEntity) {
        transaction {
            CatalogDataSourceImpl.insert {
                it[id] = newLesson.id
                it[name] = newLesson.name
                it[idCreator] = newLesson.idCreator
                it[description] = newLesson.description
            }
        }
    }

    override suspend fun redactLesson(lesson: LessonEntity) {
        transaction {
            CatalogDataSourceImpl.update({CatalogDataSourceImpl.id eq lesson.id}) {
                it[name] = lesson.name
                it[description] = lesson.description
            }
        }
    }

    override suspend fun deleteLesson(idLesson: String) {
        transaction {
            CatalogDataSourceImpl.deleteWhere {CatalogDataSourceImpl.id.eq(idLesson)}
        }
    }
}