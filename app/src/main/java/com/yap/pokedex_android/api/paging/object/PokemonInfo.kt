package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonInfo(
    @SerializedName("abilities")
    @Expose
    val abilities: List<Abilities>,

    @SerializedName("base_experience")
    @Expose
    val baseExperience : Int,

    @SerializedName("forms")
    @Expose
    val forms : List<PokemonVO>,

    @SerializedName("game_indices")
    @Expose
    val gameIndices : List<GameIndice>,

    @SerializedName("held_items")
    @Expose
    val heldItems: List<HeldItem>,

    @SerializedName("id")
    @Expose
    val id : Long,

    @SerializedName("is_default")
    @Expose
    val isDefault : Boolean,

    @SerializedName("location_area_encounters")
    @Expose
    val locationArea_Encounters : String,

    @SerializedName("moves")
    @Expose
    val moves : List<Moves>,

    @SerializedName("name")
    @Expose
    val name : String,

    @SerializedName("order")
    @Expose
    val order : Int,

    @SerializedName("species")
    @Expose
    val species : PokemonVO,

    @SerializedName("sprites")
    @Expose
    val sprite : Sprites,

    @SerializedName("stats")
    @Expose
    val stats : List<Stats>,

    @SerializedName("types")
    @Expose
    val types : List<Types>,

    @SerializedName("weight")
    val weight : Int
)