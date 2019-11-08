package com.yap.pokedex_android.api.paging.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.yap.pokedex_android.AppExecutors
import com.yap.pokedex_android.api.PokeAPIService
import com.yap.pokedex_android.api.paging.NetworkState
import com.yap.pokedex_android.api.paging.`object`.PokemonVO
import com.yap.pokedex_android.api.paging.`object`.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class PokemonListPagedKeyDS(private val apiService: PokeAPIService,
                            private val retryExecutors: AppExecutors)
    : PageKeyedDataSource<String, PokemonVO> () {

    private var retry : (() -> Any)? = null

    val networkState = MutableLiveData<NetworkState>()

    val initialLoad = MutableLiveData<NetworkState>()

    var offset = 0

    fun retryAllFailed() {
        val prevRetry = retry
        retry = null
        prevRetry?.let {
            retryExecutors.networkIO().execute {
                it.invoke()
            }
        }
    }

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, PokemonVO>) {

        Log.d("LOG_TAG", "loadInitial()")

        val request = apiService.getTop(20, offset)

        networkState.postValue(NetworkState.LOADING)
        initialLoad.postValue(NetworkState.LOADING)

        try{
            val response = request.execute()
            val data = response.body()

            val item = data?.lists?.map { it } ?: emptyList()

            retry = null
            networkState.postValue(NetworkState.LOADED)
            initialLoad.postValue(NetworkState.LOADED)
            callback.onResult(item, (offset - 20).toString(), (offset + 20).toString())

        }catch (exception : IOException) {
            retry = {
                loadInitial(params, callback)
            }
            val error = NetworkState.error(exception.message ?: "unknown error")
            networkState.postValue(error)
            initialLoad.postValue(error)
        }


    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, PokemonVO>) {

        offset += 20

        Log.d("LOG_TAG", "loadAfter()")

        networkState.postValue(NetworkState.LOADING)
        apiService.getTopAfter(params.requestedLoadSize, Integer.parseInt(params.key)).enqueue(object : Callback<PokemonResponse>{
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                retry = {
                    loadAfter(params, callback)
                }
            }

            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                if(response.isSuccessful) {

                    val data = response.body()
                    val item = data?.lists?.map { it } ?: emptyList()

                    retry = null
                    callback.onResult(item, (offset + 20).toString())
                }else {
                    retry = {
                        loadAfter(params, callback)
                    }
                    networkState.postValue(NetworkState.error("error code : ${response.code()}"))
                }
            }
        })


    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, PokemonVO>) {
    }

}