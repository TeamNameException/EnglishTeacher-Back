package ru.teamnameexception.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import ru.teamnameexception.Singleton
import ru.teamnameexception.domain.entities.ResultEntity
import ru.teamnameexception.plugins.entities.lesson.LessonReceive
import ru.teamnameexception.plugins.entities.lesson.LessonResponse
import ru.teamnameexception.plugins.entities.result.GetResultReceive
import ru.teamnameexception.plugins.entities.result.GetResultResponse
import ru.teamnameexception.plugins.entities.result.PutResultReceive
import ru.teamnameexception.plugins.entities.word.WordReceive
import ru.teamnameexception.plugins.entities.word.WordResponse


fun Application.configureGameRouting() {


    routing {

        post("/lessons") {
            coroutineScope {
                try {
                    val idLesson = call.receive<LessonReceive>().lessonId

                    val lesson = Singleton.getLessonUseCase.getLesson(idLesson)

                    val words = Singleton.getWordsUseCase.getWords(idLesson)

                    call.respond(
                        LessonResponse(
                            lesson.id,
                            lesson.name,
                            lesson.description,
                            lesson.idCreator,
                            words
                        )
                    )
                } catch (_: Exception) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        post("/word") {
            coroutineScope {
                try {
                    val idLesson = call.receive<WordReceive>().idLesson
                    val words = Singleton.getWordsUseCase.getWords(idLesson)
                    call.respond(WordResponse(words))
                } catch (_: Exception) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        post("/result") {
            coroutineScope {
                val token = call.receive<GetResultReceive>().token

                val idUser = Singleton.isLoggedUseCase.isLogged(token)

                if (idUser.first) {
                    val results = Singleton.resultUseCase.getResult(idUser.second)
                    call.respond(GetResultResponse(results))
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

        put("/result") {
            coroutineScope {
                val receive = call.receive<PutResultReceive>()

                val idUser = Singleton.isLoggedUseCase.isLogged(receive.token)

                if (idUser.first) {
                    Singleton.resultUseCase.setResult(
                        ResultEntity(
                            receive.idLesson,
                            idUser.second,
                            receive.time,
                            receive.countCorrect,
                            receive.countWrong
                        )
                    )
                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }

    }
}