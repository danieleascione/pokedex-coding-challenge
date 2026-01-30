package com.truelayer.acceptance

import dsl.startApplicationEndToEnd
import io.kotest.matchers.shouldBe
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode.Companion.OK
import kotlinx.serialization.Serializable
import org.junit.jupiter.api.Test

class EndToEndTest {

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
    @Test
    fun `returns name of existing pokemon`() = startApplicationEndToEnd {
        // Given
        val existingPokemonName = "pikachu"

        // When
        val response = it.get("/pokemon/$existingPokemonName")

        // Then
        response.status shouldBe OK
        response.body<PokemonResponse>().name shouldBe existingPokemonName
    }

    @Serializable
    data class PokemonResponse(val name: String)
}
