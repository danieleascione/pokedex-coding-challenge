package com.truelayer.pokemon.info

import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import kotlinx.serialization.Serializable

@Serializable
data class PokedexHttpResponse(val name: String)

fun Route.pokemonInfo() {
    get("/pokemon/{name}") {
    }
}
