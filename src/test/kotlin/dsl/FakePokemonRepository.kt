package dsl

import com.truelayer.pokemon.info.Pokemon
import com.truelayer.pokemon.info.PokemonRepository

class FakePokemonRepository : PokemonRepository {

    val pokemons = mutableListOf<Pokemon>()

    fun knowsAbout(pokemon: Pokemon) {
        pokemons += pokemon
    }

    override suspend fun findByName(name: String): Pokemon? = pokemons.find { it.name == name }
}
