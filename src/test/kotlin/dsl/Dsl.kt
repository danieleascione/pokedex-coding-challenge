package dsl

import com.truelayer.acceptance.RetrievePokemonNameTest.PokemonResponse
import com.truelayer.pokedexApp
import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.ApplicationTestBuilder
import io.ktor.server.testing.testApplication

/**
 * TODO: Improve this function less cryptic. The goal is to:
 * - Setup the client so that it reads JSON out of the box
 * - Allow the user to call the correct endpoint without necessarily overspecifying the details
 */
fun startPokedex(block: suspend ApplicationTestBuilder.(HttpClient) -> Unit) = testApplication {
    // Configure the application
    application { pokedexApp() }

    // Configure the test client with JSON support
    val client = createClient { install(ContentNegotiation) { json() } }
    block(client)
}

suspend fun HttpClient.getPokemonByName(pokemonName: String): PokemonResponse {
    val response = get("/pokemon/$pokemonName")
    response.status shouldBe OK
    return response.body<PokemonResponse>()
}
