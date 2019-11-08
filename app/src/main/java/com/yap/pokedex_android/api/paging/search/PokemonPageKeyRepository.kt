package com.yap.pokedex_android.api.paging.search

import androidx.lifecycle.Transformations
import androidx.paging.toLiveData
import com.yap.pokedex_android.AppExecutors
import com.yap.pokedex_android.api.PokeAPIService
import com.yap.pokedex_android.api.paging.Listing
import com.yap.pokedex_android.api.paging.`object`.PokemonVO
import javax.inject.Inject

class PokemonPageKeyRepository @Inject constructor(private val apiService : PokeAPIService,
                                                   private val appExecutors: AppExecutors
) : PokemonListRepository{

    override fun listsOfPokemon(page: Int): Listing<PokemonVO> {


        val sourceFactory = PokemonListDSFactory(apiService, appExecutors)

        val livePagedList = sourceFactory.toLiveData(pageSize = 20,
            fetchExecutor = appExecutors.networkIO())

        val refreshState = Transformations.switchMap(sourceFactory.liveData) {
            it.initialLoad
        }

        return Listing(pagedList = livePagedList,
            networkState = Transformations.switchMap(sourceFactory.liveData) {
                it.networkState
            }, retry = {
                sourceFactory.liveData.value?.retryAllFailed()
            }, refresh = {
                sourceFactory.liveData.value?.invalidate()
            }, refreshState = refreshState
        )

    }
}