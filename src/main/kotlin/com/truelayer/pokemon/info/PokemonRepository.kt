package com.truelayer.pokemon.info

data class Pokemon(val name: String)

interface PokemonRepository {
    suspend fun findByName(name: String): Pokemon
}
