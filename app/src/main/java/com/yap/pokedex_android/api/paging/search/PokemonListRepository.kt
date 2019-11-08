package com.yap.pokedex_android.api.paging.search

import com.yap.pokedex_android.api.paging.Listing
import com.yap.pokedex_android.api.paging.`object`.PokemonVO

interface PokemonListRepository {
    fun listsOfPokemon(page : Int) : Listing<PokemonVO>
}