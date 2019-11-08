package com.yap.pokedex_android.ui.search.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yap.pokedex_android.api.paging.Listing
import com.yap.pokedex_android.api.paging.`object`.PokemonVO
import com.yap.pokedex_android.api.paging.search.PokemonPageKeyRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val repository : PokemonPageKeyRepository) : ViewModel(){

    var repoResult = MutableLiveData<Listing<PokemonVO>>()
    val pokemon = Transformations.switchMap(repoResult) { it.pagedList }
    val networkState = Transformations.switchMap(repoResult) { it.networkState }
    val refreshState = Transformations.switchMap(repoResult) { it.refreshState }

    init {
        repoResult.postValue(repository.listsOfPokemon(20))
    }

    fun refresh() {
        repoResult.value?.refresh?.invoke()
    }

    fun retry() {
        repoResult.value?.retry?.invoke()
    }


}