package com.example.exercise1.data

import retrofit2.http.GET
import retrofit2.http.Path

interface JokeApi {
    @GET("jokes/{type}/ten")
    suspend fun listJokes (@Path("type") type : String): List<Joke>
}