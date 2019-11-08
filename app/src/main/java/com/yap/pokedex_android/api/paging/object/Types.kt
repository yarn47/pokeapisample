package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.SerializedName

data class Types(
    @SerializedName("slot")
    val slot : Int,

    @SerializedName("type")
    val type : PokemonVO
)