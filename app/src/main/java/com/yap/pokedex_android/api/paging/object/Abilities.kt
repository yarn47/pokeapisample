package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Abilities(
    @SerializedName("ability")
    @Expose
    val ability: Ability,

    @SerializedName("is_hidden")
    @Expose
    val isHidden : Boolean,
    @SerializedName("slot")
    @Expose
    val slot : Int)