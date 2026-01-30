package com.truelayer

import com.truelayer.pokemon.info.PokeApiPokemonRepository
import com.truelayer.pokemon.info.PokemonRepository
import com.truelayer.pokemon.info.pokemonInfo
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing

fun Application.pokedexApp(pokemonRepository: PokemonRepository = PokeApiPokemonRepository()) {
    install(ContentNegotiation) {
        json()
    }

    routing {
        pokemonInfo(pokemonRepository)
    }
}
