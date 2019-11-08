package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VersionDetails(

    @SerializedName("rarity")
    @Expose
    val rariry : Int,

    @SerializedName("version")
    @Expose
    val version : PokemonVO

)