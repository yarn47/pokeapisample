package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("name")
    @Expose
    private val name: String,
    @SerializedName("url")
    @Expose
    private val url: String
)