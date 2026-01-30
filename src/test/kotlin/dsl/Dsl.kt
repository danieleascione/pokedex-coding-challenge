package dsl

import com.truelayer.pokedexApp
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.ApplicationTestBuilder
import io.ktor.server.testing.testApplication

/**
 * TODO: Improve this function less cryptic. The goal is to:
 * - Setup the client so that it reads JSON out of the box
 * - Allow the user to call the correct endpoint without necessarily overspecifying the details
 */
fun startApplicationEndToEnd(testScenario: suspend ApplicationTestBuilder.(HttpClient) -> Unit) = testApplication {
    // Configure the application
    application { pokedexApp() }

    // Configure the test client with JSON support
    val client = createClient { install(ContentNegotiation) { json() } }
    testScenario(client)
}

fun startWithStubbedDependencies(testScenario: suspend PokedexAppContext.(PokedexAppContext) -> Unit) = testApplication {
    // Configure the application
    application { pokedexApp() }

    // Configure the test client with JSON support
    val client = createClient { install(ContentNegotiation) { json() } }
    val appContext = PokedexAppContext(client, FakePokemonRepository())
    appContext.testScenario(appContext)
}

class PokedexAppContext(val pokedexClient: HttpClient, val pokemonRepository: FakePokemonRepository)
