package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Genus(

    @SerializedName("genus")
    @Expose
    val genus : String,

    @SerializedName("language")
    @Expose
    val language : PokemonVO
)