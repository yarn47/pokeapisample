package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("base_stat")
    @Expose
    val baseStat : Int,

    @SerializedName("effort")
    @Expose
    val effort : Int,

    @SerializedName("stat")
    @Expose
    val stat : PokemonVO
)