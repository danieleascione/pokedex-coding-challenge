package com.truelayer.acceptance

import com.truelayer.pokedexApp
import io.kotest.matchers.shouldBe
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
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
    fun `given a valid Pokemon name, when I request that Pokemon, then the response includes the Pokemon's name in JSON format`() = testApplication {
        // Configure the application
        application {
            pokedexApp()
        }

        // Configure the test client with JSON support
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        // Given a valid Pokemon name
        val pokemonName = "pikachu"

        // When I request that Pokemon via the REST API
        val response = client.get("/pokemon/$pokemonName")

        // Then the response is successful with JSON content type
        response.status shouldBe HttpStatusCode.OK
        response.contentType()?.withoutParameters() shouldBe ContentType.Application.Json

        // And the response includes the Pokemon's name matching what was requested
        val body = response.body<PokemonResponse>()
        body.name shouldBe "pikachu"
    }

    @Serializable
    data class PokemonResponse(
        val name: String
    )
}
