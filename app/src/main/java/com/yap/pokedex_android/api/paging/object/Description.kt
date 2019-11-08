package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("description")
    @Expose
    val description: String,

    @SerializedName("language")
    @Expose
    val language : PokemonVO
)