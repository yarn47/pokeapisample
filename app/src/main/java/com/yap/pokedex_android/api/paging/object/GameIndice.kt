package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GameIndice(

    @SerializedName("game_index")
    @Expose
    val gameIndex : Int,

    @SerializedName("version")
    @Expose
    val version : PokemonVO

)