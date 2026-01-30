package com.truelayer.pokemon.info

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

/**
 * Test plan for PokeApiPokemonRepository:
 * - returns pokemon when name exists (CURRENT)
 * - returns null when pokemon does not exist
 * - handles case-insensitive names
 * - handles network timeout gracefully
 * - handles API 5xx errors
 * - handles malformed JSON response
 *
 * TODO: Refactor interface to return Result<Pokemon> using kotlin.Result
 * (zero dependencies - https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-result/)
 */
class PokeApiPokemonRepositoryTest {

    private val repository = PokeApiPokemonRepository()

    @Test
    fun `returns pokemon when name exists`() = runTest {
        // When
        val pokemon = repository.findByName("pikachu")

        // Then
        pokemon.shouldNotBeNull()
        pokemon.name shouldBe "pikachu"
    }
}
