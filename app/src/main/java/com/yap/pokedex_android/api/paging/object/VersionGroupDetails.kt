package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VersionGroupDetails(
    @SerializedName("level_learned_at")
    @Expose
    val levelLearnAt : Int,

    @SerializedName("move_learn_method")
    @Expose
    val moveLearnMethod : PokemonVO,

    @SerializedName("version_group")
    @Expose
    val versionGroup : PokemonVO

)