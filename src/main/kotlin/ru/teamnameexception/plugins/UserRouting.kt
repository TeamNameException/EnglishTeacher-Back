package ru.teamnameexception.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import ru.teamnameexception.Singleton
import ru.teamnameexception.plugins.entities.user.UserReceive
import ru.teamnameexception.plugins.entities.user.UserRenameReceive
import ru.teamnameexception.plugins.entities.user.UserResponse


fun Application.configureUserRouting() {


    routing {

        patch("/user") {
            coroutineScope {
                val receive = call.receive<UserRenameReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    Singleton.renameUserUseCase.renameUser(userId.second, receive.newName)
                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }


        post("/user") {
            coroutineScope {
                val token = call.receive<UserReceive>().token

                val userId = Singleton.isLoggedUseCase.isLogged(token)

                if (userId.first) {
                    val user = Singleton.getUserUseCase.getUser(userId.second)
                    call.respond(
                        UserResponse(
                            user.id,
                            user.name,
                            user.login
                        )
                    )
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }
    }
}