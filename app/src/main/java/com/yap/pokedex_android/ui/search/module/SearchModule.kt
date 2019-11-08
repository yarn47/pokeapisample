package com.yap.pokedex_android.ui.search.module

import com.yap.pokedex_android.AppExecutors
import com.yap.pokedex_android.api.PokeAPIService
import com.yap.pokedex_android.api.paging.search.PokemonListRepository
import com.yap.pokedex_android.api.paging.search.PokemonPageKeyRepository
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    fun providePokemonListRepository(apiService: PokeAPIService, appExecutors: AppExecutors) : PokemonListRepository {
        return PokemonPageKeyRepository(apiService, appExecutors)
    }
}