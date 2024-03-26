package ru.teamnameexception.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import ru.teamnameexception.Singleton
import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.plugins.entities.lesson.CreateLessonReceive
import ru.teamnameexception.plugins.entities.lesson.CreateLessonResponse
import ru.teamnameexception.plugins.entities.lesson.DeleteLessonReceive
import ru.teamnameexception.plugins.entities.lesson.PatchLessonReceive
import ru.teamnameexception.plugins.entities.word.AddWordReceive
import ru.teamnameexception.plugins.entities.word.DeleteWordReceive
import java.util.*


fun Application.configureLessonRouting() {


    routing {

        put("/lesson") {
            coroutineScope {
                val receive = call.receive<CreateLessonReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)
                val lessonId = UUID.randomUUID().toString().substring(0..17)
                if (userId.first) {
                    Singleton.createLessonUseCase.createLesson(
                        LessonEntity(
                            lessonId,
                            receive.name,
                            receive.description,
                            userId.second
                        )
                    )
                    call.respond(CreateLessonResponse(lessonId))
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        patch("/lesson") {
            coroutineScope {
                val receive = call.receive<PatchLessonReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    val lesson = Singleton.getLessonUseCase.getLesson(receive.idLesson)
                    if (lesson.idCreator == userId.second) {
                        Singleton.redactLessonUseCase.redactLesson(
                            LessonEntity(
                                receive.idLesson,
                                receive.name,
                                receive.description,
                                userId.second
                            )
                        )
                        call.respond(HttpStatusCode.OK)
                    } else {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        delete("/lesson") {
            coroutineScope {
                val receive = call.receive<DeleteLessonReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    val lessonCreatorId = Singleton.getLessonUseCase.getLesson(receive.idLesson).idCreator
                    if (userId.second == lessonCreatorId) {
                        Singleton.deleteLessonUseCase.deleteLesson(receive.idLesson)
                        call.respond(HttpStatusCode.OK)
                    } else {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        put("/word") {
            coroutineScope {
                val receive = call.receive<AddWordReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    val idCreator = Singleton.getLessonUseCase.getLesson(receive.idLesson).idCreator
                    if (idCreator == userId.second) {
                        Singleton.addWordUseCase.addWord(receive.words, receive.idLesson)
                        call.respond(HttpStatusCode.OK)
                    } else {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        delete("/word") {
            coroutineScope {
                val receive = call.receive<DeleteWordReceive>()

                val userId = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (userId.first) {
                    val idCreator = Singleton.getLessonUseCase.getLesson(receive.idLesson).idCreator
                    if (idCreator == userId.second) {
                        Singleton.deleteWordUseCase.deleteWords(receive.words, receive.idLesson)
                        call.respond(HttpStatusCode.OK)
                    } else {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

    }
}