package ru.teamnameexception

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import ru.teamnameexception.plugins.*

fun main() {
    Database.connect("jdbc:postgresql://localhost:5432/english_teacher_back_database", driver = "org.postgresql.Driver",
        "postgres", "1483369")

    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    configureSerialization()

    configureRouting()
    configureLoginRouting()
    configureCatalogRouting()
}
