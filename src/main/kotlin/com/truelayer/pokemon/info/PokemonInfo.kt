package com.truelayer.pokemon.info

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import kotlinx.serialization.Serializable

@Serializable
data class PokedexHttpResponse(val name: String)

fun Route.pokemonInfo(pokemonRepository: PokemonRepository) {
    get("/pokemon/{name}") {
        val name = call.parameters["name"]!!

        val pokemon = pokemonRepository.findByName(name)

        if (pokemon == null) {
            call.respond(HttpStatusCode.NotFound)
        } else {
            call.respond(PokedexHttpResponse.fromPokemon(pokemon))
        }
    }
}

fun PokedexHttpResponse.Companion.fromPokemon(pokemon: Pokemon) = PokedexHttpResponse(pokemon.name)
