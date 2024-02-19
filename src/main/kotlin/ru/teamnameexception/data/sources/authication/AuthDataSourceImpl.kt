package ru.teamnameexception.data.sources.authication

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

object AuthDataSourceImpl : AuthDataSource, Table("token") {

    private val idUser = AuthDataSourceImpl.varchar("id_user", 18)
    private val token = AuthDataSourceImpl.varchar("token", 18)


    override suspend fun login(idUser: String): String {
        val newToken = UUID.randomUUID().toString().substring(0..17)
        transaction {
            AuthDataSourceImpl.insert {
                it[AuthDataSourceImpl.idUser] = idUser
                it[token] = newToken
            }
        }
        return newToken
    }

    override suspend fun logout(token: String) {
        transaction {
            AuthDataSourceImpl.deleteWhere {
                AuthDataSourceImpl.token eq token
            }
        }
    }

    override suspend fun isLogged(token: String): Pair<Boolean, String> {
        return try {
            val databaseEntity = AuthDataSourceImpl.select { AuthDataSourceImpl.token.eq(token) }.single()
            Pair(true, databaseEntity[idUser])
        } catch (_: Exception) {
            Pair(false, "")
        }
    }

}