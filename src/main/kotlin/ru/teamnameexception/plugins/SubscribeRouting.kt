package ru.teamnameexception.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import ru.teamnameexception.Singleton
import ru.teamnameexception.domain.entities.SubscriberEntity
import ru.teamnameexception.plugins.entities.subscribe.AddSubscribeReceive
import ru.teamnameexception.plugins.entities.subscribe.SubscribersReceive
import ru.teamnameexception.plugins.entities.subscribe.SubscribersResponse
import ru.teamnameexception.plugins.entities.subscribe.UnsubscribeReceive

fun Application.configureSubscribeRouting() {

    routing {
        post("/sub") {
            coroutineScope {
                val receive = call.receive<SubscribersReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    val subscribers = Singleton.getSubscribersUseCase.getSubscribers(userId.second, receive.limit, receive.offset)

                    call.respond(SubscribersResponse(subscribers))
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        put("/sub") {
            coroutineScope {
                val receive = call.receive<AddSubscribeReceive>()

                val subscriberId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (subscriberId.first) {
                    val nameSubscriber = Singleton.getUserUseCase.getUser(subscriberId.second).name
                    val subscriber = SubscriberEntity(
                        subscriberId.second,
                        nameSubscriber
                    )
                    Singleton.subscribeUseCase.subscribe(receive.userId, subscriber)
                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }

            }
        }

        delete("/sub") {
            coroutineScope {
                val receive = call.receive<UnsubscribeReceive>()

                val subscriberId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (subscriberId.first) {
                    Singleton.unsubscribeUseCase.unsubscribe(receive.userId, subscriberId.second)
                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }

            }
        }
    }
}