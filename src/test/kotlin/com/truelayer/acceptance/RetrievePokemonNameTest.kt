package com.truelayer.acceptance

import dsl.startPokedex
import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.OK
import kotlinx.serialization.Serializable
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
    fun `returns name of existing pokemon`() = startPokedex {
        // Given
        val existingPokemonName = "pikachu"

        // When
        val response = it.get("/pokemon/$existingPokemonName")

        // Then
        response.status shouldBe OK
        response.body<PokemonResponse>() shouldBe existingPokemonName
    }

    @Test
    fun `returns 404 for non-existing pokemon`() = startPokedex {
        // Given
        val nonExistingPokemonName = nonExistingPokemonName()

        // When
        val response = it.get("/pokemon/$nonExistingPokemonName")

        // Then
        response.status shouldBe HttpStatusCode.NotFound
    }

    private fun nonExistingPokemonName(): String = "notapokemon-${UUID.randomUUID()}"

    @Serializable
    data class PokemonResponse(val name: String)
}
