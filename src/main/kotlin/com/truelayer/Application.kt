package com.truelayer

import com.truelayer.pokemon.info.pokemonInfo
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

fun Application.pokedexApp() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        pokemonInfo()
    }
}
