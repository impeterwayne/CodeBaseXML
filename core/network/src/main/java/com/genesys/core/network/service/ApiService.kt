package com.genesys.core.network.service

import com.genesys.core.network.dto.pokedex.ResponsePokemonList
import com.skydoves.sandwich.ApiResponse
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Streaming
import retrofit2.http.Url

interface ApiService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): ApiResponse<ResponsePokemonList>

    @Streaming
    @GET
    suspend fun downloadFile(@Url fileUrl: String): ResponseBody

}
