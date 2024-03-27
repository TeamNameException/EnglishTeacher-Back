package ru.teamnameexception.data.sources.subscribe

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import ru.teamnameexception.domain.entities.SubscriberEntity

object SubscribeDataSourceImpl : SubscribeDataSource, Table("subscribe") {

    private val idSubscriber = SubscribeDataSourceImpl.varchar("id_subscriber", 18)
    private val idUser = SubscribeDataSourceImpl.varchar("id_user", 18)
    private val nameSubscriber = SubscribeDataSourceImpl.varchar("name_subscriber", 50)
    override suspend fun getSubscribers(idUser: String, limit: Int, offset: Int): List<SubscriberEntity> {
        return transaction {
            return@transaction SubscribeDataSourceImpl.select { SubscribeDataSourceImpl.idUser.eq(idUser) }
                .limit(limit, offset.toLong())
                .map {
                    SubscriberEntity(
                        it[idSubscriber],
                        it[nameSubscriber]
                    )
                }
        }
    }

    override suspend fun subscribe(idUser: String, subscriber: SubscriberEntity) {
        transaction {
            SubscribeDataSourceImpl.insert {
                it[idSubscriber] = subscriber.idSubscriber
                it[SubscribeDataSourceImpl.idUser] = idUser
                it[nameSubscriber] = subscriber.nameSubscriber
            }
        }
    }

    override suspend fun unsubscribe(idUser: String, idSubscriber: String) {
        transaction {
            SubscribeDataSourceImpl.deleteWhere {
                (SubscribeDataSourceImpl.idSubscriber.eq(idSubscriber)) and
                        (SubscribeDataSourceImpl.idUser.eq(idUser))
            }
        }
    }


}