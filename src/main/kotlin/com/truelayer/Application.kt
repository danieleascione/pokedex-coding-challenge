package com.truelayer

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(val name: String)

fun Application.pokedexApp() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/pokemon/{name}") {
            val name = call.parameters["name"]!!
            call.respond(PokemonResponse(name = name))
        }
    }
}
