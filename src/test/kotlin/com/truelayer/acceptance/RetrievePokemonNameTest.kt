package com.truelayer.acceptance

import dsl.getPokemonByName
import dsl.startPokedex
import io.kotest.matchers.shouldBe
import kotlinx.serialization.Serializable
import org.junit.jupiter.api.Test

/**
 * Story 1.1: Retrieve Pokemon Name
 *
 * As a parent sharing Pokemon facts with my child
 * I want to retrieve a Pokemon's name by searching for it
 * So that I can confirm I'm looking at the correct Pokemon before sharing details
 *
 * Acceptance Criteria:
 * - Given a valid Pokemon name, the response includes the Pokemon's name
 * - The returned name matches the Pokemon that was requested
 * - The response is in a readable format (JSON)
 */
class RetrievePokemonNameTest {

    @Test
    fun `returns name of existing pokemon`() = startPokedex {
        // Given
        val existingPokemonName = "pikachu"

        // When
        val response = it.getPokemonByName(existingPokemonName)

        // Then
        response.name shouldBe existingPokemonName
    }

    @Serializable
    data class PokemonResponse(val name: String)
}
