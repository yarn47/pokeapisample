package com.yap.pokedex_android.api.paging.search

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.yap.pokedex_android.AppExecutors
import com.yap.pokedex_android.api.PokeAPIService
import com.yap.pokedex_android.api.paging.`object`.PokemonVO

class PokemonListDSFactory(private val apiService: PokeAPIService,
                           private val retryExecutors: AppExecutors)
    : DataSource.Factory<String, PokemonVO>(){

    val liveData = MutableLiveData<PokemonListPagedKeyDS>()

    override fun create(): DataSource<String, PokemonVO> {
        val source = PokemonListPagedKeyDS(apiService, retryExecutors)
        liveData.postValue(source)
        return source
    }
}