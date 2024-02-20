package ru.teamnameexception.data.sources.user

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import ru.teamnameexception.domain.entities.SignUpEntity
import ru.teamnameexception.domain.entities.UserEntity

object UserDataSourceImpl : UserDataSource, Table("user") {
    private val id = UserDataSourceImpl.varchar("id", 18)
    private val name = UserDataSourceImpl.varchar("name", 18)
    private val login = UserDataSourceImpl.varchar("login", 18)
    private val password = UserDataSourceImpl.varchar("password", 18)
    override suspend fun getUser(id: String): UserEntity {
        val databaseEntity = UserDataSourceImpl.select {
            UserDataSourceImpl.id.eq(id)
        }.single()
        return UserEntity(
            databaseEntity[UserDataSourceImpl.id],
            databaseEntity[name],
            databaseEntity[login]
        )
    }

    override suspend fun renameUser(id: String, newName: String) {
        transaction {
            UserDataSourceImpl.update({ UserDataSourceImpl.id eq id }) {
                it[name] = newName
            }
        }
    }

    override suspend fun createUser(newUser: SignUpEntity) {
        var user: Any? = null
        transaction {
            user = UserDataSourceImpl.select {
                login.eq(newUser.login)
            }.firstOrNull()
            if (user == null) {
                UserDataSourceImpl.insert {
                    it[id] = newUser.id
                    it[name] = newUser.name
                    it[login] = newUser.login
                    it[password] = newUser.password
                }
            }
        }
        if (user != null)
            throw Exception()
    }


    override suspend fun getUserId(login: String, password: String): String {
        var userId = ""
        transaction {
            val databaseEntity = UserDataSourceImpl.select { UserDataSourceImpl.login.eq(login) }.single()
            if (password == databaseEntity[UserDataSourceImpl.password])
                userId = databaseEntity[UserDataSourceImpl.id]
        }
        return userId
    }


}