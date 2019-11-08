package com.yap.pokedex_android.api

import com.yap.pokedex_android.api.paging.`object`.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeAPIService {

    @GET("/api/v2/pokemon/")
    fun getTop(@Query("limit") limit : Int,
               @Query("offset") offset : Int): Call<PokemonResponse>

    @GET("/api/v2/pokemon/")
    fun getTopAfter(@Query("limit") limit : Int,
               @Query("offset") offset : Int): Call<PokemonResponse>

    @GET("/api/v2/pokemon/")
    fun getTopBefore(@Query("limit") limit : Int,
               @Query("offset") offset : Int): Call<PokemonResponse>

}