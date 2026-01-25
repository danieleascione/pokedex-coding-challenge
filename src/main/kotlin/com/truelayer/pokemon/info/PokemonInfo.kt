package com.truelayer.pokemon.info

import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfoResponse(val name: String)

fun Route.pokemonInfo() {
    get("/pokemon/{name}") {
        val name = call.parameters["name"]!!
        call.respond(PokemonInfoResponse(name = name))
    }
}
