package com.example.evilinsult.network

import com.example.evilinsult.models.Insulto
import retrofit2.Response
import retrofit2.http.GET


interface InsultApi {

    @GET("generate_insult.php?lang=en&type=json")
    suspend fun getInsult(): Insulto


}