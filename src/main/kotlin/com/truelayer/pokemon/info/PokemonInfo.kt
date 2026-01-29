package com.truelayer.pokemon.info

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfoResponse(val name: String)

fun Route.pokemonInfo() {
    get("/pokemon/{name}") {
        val name = call.parameters["name"]!!

        if (name.contentEquals("notapokemon", ignoreCase = true)) {
            call.respond(HttpStatusCode.NotFound)
        }

        call.respond(PokemonInfoResponse(name = name))
    }
}
