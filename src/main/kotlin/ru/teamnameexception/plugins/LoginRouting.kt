package ru.teamnameexception.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import ru.teamnameexception.Singleton
import ru.teamnameexception.domain.entities.SignUpEntity
import ru.teamnameexception.plugins.entities.login.LoginReceive
import ru.teamnameexception.plugins.entities.login.LoginResponse
import ru.teamnameexception.plugins.entities.logout.LogOutReceive
import ru.teamnameexception.plugins.entities.signup.SignUpReceive
import java.util.UUID


fun Application.configureLoginRouting() {

    routing {

        get("/login") {
            coroutineScope {
                val receive = call.receive(LoginReceive::class)
                val idUser = Singleton.getUserIdUseCase.getUserId(receive.login, receive.password)
                if (idUser.isNotBlank()) {
                    val token = Singleton.loginUseCase.login(idUser)
                    call.respond(LoginResponse(token))
                } else {
                   call.respond(HttpStatusCode(501, "Bad login or password, try again"))
                }
            }
        }

        post("/logout") {
            coroutineScope {
                val token = call.receive(LogOutReceive::class).token
                Singleton.logOutUseCase.logout(token)
                call.respond(HttpStatusCode.OK)
            }
        }

        post("/signup") {
            coroutineScope {
                val newUser = call.receive<SignUpReceive>()
                try {
                    Singleton.signUpUseCase.signUp(SignUpEntity(
                        UUID.randomUUID().toString().substring(0..17),
                        newUser.name,
                        newUser.login,
                        newUser.password
                    ))
                    call.respond(HttpStatusCode.OK)
                } catch (_: Exception) {
                    call.respond(HttpStatusCode(502, "USER WITH THIS LOGIN ALREADY EXIST"))
                }

            }
        }

    }




}