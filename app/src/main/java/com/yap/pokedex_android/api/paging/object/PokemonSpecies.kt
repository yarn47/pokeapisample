package com.yap.pokedex_android.api.paging.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.yap.pokedex_android.FlavorTexts

data class PokemonSpecies(
    @SerializedName("base_happiness")
    @Expose
    val baseHappiness : Int,

    @SerializedName("capture_rate")
    @Expose
    val captureRate : Int,

    @SerializedName("color")
    @Expose
    val color : PokemonVO,

    @SerializedName("egg_groups")
    @Expose
    val eggGroups : List<PokemonVO>,

    @SerializedName("evolution_chain")
    @Expose
    val evolutionChain : String,

    @SerializedName("evolves_from_species")
    @Expose
    val evolvesFromSpecies : PokemonVO,

    @SerializedName("flavor_text_entries")
    @Expose
    val flavorTextEntries : List<FlavorTexts>,

    @SerializedName("form_descriptions")
    @Expose
    val description : List<Description>,

    @SerializedName("forms_switchable")
    @Expose
    val formsSwitchable : Boolean,

    @SerializedName("gender_rate")
    @Expose
    val genderRate : Int,

    @SerializedName("genera")
    @Expose
    val genera : List<Genus>,

    @SerializedName("generation")
    @Expose
    val generation : PokemonVO,

    @SerializedName("growth_rate")
    @Expose
    val growthRate : PokemonVO,

    @SerializedName("habitat")
    @Expose
    val habitat : PokemonVO,

    @SerializedName("has_gender_differences")
    @Expose
    val hasGenderDifferences : Boolean,

    @SerializedName("hatch_counter")
    @Expose
    val hatchCounter : Int,

    @SerializedName("id")
    @Expose
    val id : Long,

    @SerializedName("is_baby")
    @Expose
    val isBaby : Boolean,

    @SerializedName("name")
    @Expose
    val name : String,

    @SerializedName("names")
    @Expose
    val names : List<Names>,

    @SerializedName("order")
    @Expose
    val order : Int,

    @SerializedName("pal_park_encounters")
    @Expose
    val

)