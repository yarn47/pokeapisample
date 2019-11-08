package com.yap.pokedex_android

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.yap.pokedex_android.api.paging.`object`.PokemonVO

data class FlavorTexts(
    @SerializedName("flavor_text")
    @Expose
    val flavorText : String,

    @SerializedName("language")
    @Expose
    val language : PokemonVO,

    @SerializedName("version")
    @Expose
    val version : String
)