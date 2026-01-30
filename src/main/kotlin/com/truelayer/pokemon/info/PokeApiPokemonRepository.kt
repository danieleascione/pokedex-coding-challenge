package com.truelayer.pokemon.info

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class PokeApiPokemonRepository : PokemonRepository {

    private val httpClient = HttpClient.newHttpClient()
    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun findByName(name: String): Pokemon? {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://pokeapi.co/api/v2/pokemon-species/$name"))
            .GET()
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        if (response.statusCode() == 404) {
            return null
        }

        val apiResponse = json.decodeFromString<PokeApiResponse>(response.body())
        return Pokemon(name = apiResponse.name)
    }
}

@Serializable
private data class PokeApiResponse(val name: String)
