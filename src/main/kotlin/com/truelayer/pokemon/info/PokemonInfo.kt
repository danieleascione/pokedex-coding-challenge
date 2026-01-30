package com.truelayer.pokemon.info

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfoResponse(val name: String)

fun Route.pokemonInfo(pokemonRepository: PokemonRepository) {
    get("/pokemon/{name}") {
        val name = call.parameters["name"]!!

        val pokemon = pokemonRepository.findByName(name)

        val response = pokemon?.let { PokemonInfoResponse.fromPokemon(it) } ?: call.respond(HttpStatusCode.NotFound)

        call.respond(response)
    }
}

fun PokemonInfoResponse.Companion.fromPokemon(pokemon: Pokemon) = PokemonInfoResponse(pokemon.name)
