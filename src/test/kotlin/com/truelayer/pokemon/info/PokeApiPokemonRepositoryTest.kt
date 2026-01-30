package com.truelayer.pokemon.info

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
        // Given
        val anExistingPokemonName = "pikachu"

        // When
        val result = repository.findByName(anExistingPokemonName)

        // Then
        result shouldBe Pokemon("pikachu")
    }
}
