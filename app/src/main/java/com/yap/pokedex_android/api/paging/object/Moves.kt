package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Moves(

    @SerializedName("move")
    @Expose
    val move : PokemonVO,

    @SerializedName("version_group_details")
    @Expose
    val versionGroupDetails : VersionGroupDetails

)