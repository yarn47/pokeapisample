package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HeldItem(

    @SerializedName("item")
    @Expose
    val item : PokemonVO,

    @SerializedName("version_details")
    @Expose
    val versionDetails : VersionDetails
)