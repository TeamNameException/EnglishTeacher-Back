package ru.teamnameexception.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import ru.teamnameexception.Singleton
import ru.teamnameexception.plugins.entities.catalog.CatalogResponse
import ru.teamnameexception.plugins.entities.favorite.FavoriteAddReceive
import ru.teamnameexception.plugins.entities.favorite.FavoriteReceive
import ru.teamnameexception.plugins.entities.favorite.FavoriteResponse

fun Application.configureCatalogRouting() {


    routing {

        get("/catalog") {
            coroutineScope {
                val catalog = Singleton.getCatalogUseCase.getCatalog()

                call.respond(CatalogResponse(catalog))
            }
        }


        get("/favorite") {

            coroutineScope {
                val token = call.receive<FavoriteReceive>().token

                val userId = Singleton.isLoggedUseCase.isLogged(token)

                if (userId.first) {
                    val favorites = Singleton.getCatalogUseCase.getFavorite(userId.second)
                    call.respond(FavoriteResponse(favorites))
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }

            }
        }

        post("/favorite") {
            coroutineScope {
                val receive = call.receive<FavoriteAddReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    Singleton.addFavoriteUseCase.addFavorite(userId.second, receive.lessonId)

                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        delete("/favorite") {
            coroutineScope {
                val receive = call.receive<FavoriteAddReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    Singleton.deleteFavoriteUseCase.deleteFavorite(userId.second, receive.lessonId)

                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

    }


}