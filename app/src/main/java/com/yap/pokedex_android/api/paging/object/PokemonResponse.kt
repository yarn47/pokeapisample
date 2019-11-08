package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PokemonResponse(
    @SerializedName("count")
    @Expose
    var count: Long = 0,
    @SerializedName("next")
    @Expose
    var next: String? = null,
    @SerializedName("previous")
    @Expose
    var previous: String? = null,
    @SerializedName("results")
    @Expose
    var lists: List<PokemonVO>? = null)

