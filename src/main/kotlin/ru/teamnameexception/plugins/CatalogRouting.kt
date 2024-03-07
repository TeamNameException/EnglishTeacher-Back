package ru.teamnameexception.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import ru.teamnameexception.Singleton
import ru.teamnameexception.plugins.entities.catalog.CatalogFromSubReceive
import ru.teamnameexception.plugins.entities.catalog.CatalogReceive
import ru.teamnameexception.plugins.entities.catalog.CatalogResponse
import ru.teamnameexception.plugins.entities.favorite.FavoriteAddReceive
import ru.teamnameexception.plugins.entities.favorite.FavoriteReceive
import ru.teamnameexception.plugins.entities.favorite.FavoriteResponse

fun Application.configureCatalogRouting() {


    routing {

        post("/catalog") {
            coroutineScope {
                val receive = call.receive<CatalogReceive>()
                val catalog = Singleton.getCatalogUseCase.getCatalog(receive.limit, receive.offset)

                call.respond(CatalogResponse(catalog))
            }
        }

        post("/subLesson"){
            coroutineScope {
                val receive = call.receive<CatalogFromSubReceive>()

                val catalog = Singleton.getCatalogFromSubUseCase.getCatalogFromSub(receive.idCreator, receive.limit, receive.offset)

                call.respond(CatalogResponse(catalog))
            }
        }


        put("/favorite") {

            coroutineScope {
                val receive = call.receive<FavoriteReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    val favorites = Singleton.getCatalogUseCase.getFavorite(userId.second, receive.limit, receive.offset)
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