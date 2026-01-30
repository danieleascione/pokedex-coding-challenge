package com.truelayer.acceptance

import com.truelayer.acceptance.EndToEndTest.PokemonResponse
import com.truelayer.pokemon.info.Pokemon
import dsl.startWithStubbedDependencies
import io.kotest.matchers.shouldBe
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.OK
import org.junit.jupiter.api.Test
import java.util.UUID

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
    fun `returns name of existing pokemon`() = startWithStubbedDependencies {
        // Given
        pokemonRepository.knowsAbout(Pokemon("pikachu"))

        // When
        val response = pokedexClient.get("/pokemon/pikachu")

        // Then
        response.status shouldBe OK
        response.body<PokemonResponse>().name shouldBe "pikachu"
    }

    @Test
    fun `returns 404 for non-existing pokemon`() = startWithStubbedDependencies {
        // Given
        val nonExistingPokemonName = nonExistingPokemonName()

        // When
        val response = pokedexClient.get("/pokemon/$nonExistingPokemonName")

        // Then
        response.status shouldBe HttpStatusCode.NotFound
    }

    private fun nonExistingPokemonName(): String = "notapokemon-${UUID.randomUUID()}"
}
