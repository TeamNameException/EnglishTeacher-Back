package ru.teamnameexception.data.sources.catalog

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
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
}