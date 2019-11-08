package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Names(
    @SerializedName("language")
    @Expose
    val language : PokemonVO,

    @SerializedName("name")
    @Expose
    val name : String
)