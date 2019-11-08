package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("back_default")
    @Expose
    val backDefault : String,
    @SerializedName("back_female")
    @Expose
    val backFemale : String,
    @SerializedName("back_shiny")
    @Expose
    val backShiny : String,
    @SerializedName("back_shiny_female")
    @Expose
    val backShinyFemale : String,
    @SerializedName("front_default")
    @Expose
    val frontDefault : String,
    @SerializedName("front_female")
    @Expose
    val frontFemale : String,
    @SerializedName("front_shiny")
    @Expose
    val frontShiny : String,
    @SerializedName("front_shiny_female")
    @Expose
    val fronyShinyFemale : String

)