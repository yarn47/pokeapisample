package com.yap.pokedex_android.ui.search

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yap.pokedex_android.api.paging.NetworkState

import com.yap.pokedex_android.common.BaseActivity
import com.yap.pokedex_android.ui.search.adapter.PokemonListAdapter
import com.yap.pokedex_android.ui.search.viewmodel.SearchViewModel
import com.yarn.pokedex_android.R
import com.yarn.pokedex_android.databinding.ActivitySearchBinding
import javax.inject.Inject

class SearchActivity : BaseActivity() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory

    val searchViewModel : SearchViewModel by viewModels{ factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivitySearchBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_search)

        binding.apply {
            viewModel = searchViewModel
            recyclerView.adapter = null
            initAdapter(this)
            initRefresh(this)
        }

    }

    private fun initAdapter(binding : ActivitySearchBinding) {
        val adapter = PokemonListAdapter {
            binding.viewModel!!.retry()
        }
        binding.apply {
            recyclerView.adapter = adapter
            viewModel!!.pokemon.observe(this@SearchActivity, Observer {
                adapter.submitList(it)
            })
            /*
            viewModel.networkState.observe(this@SearchActivity, Observer {
                adapter.submitList(it)
            })*/
        }


    }

    private fun initRefresh(binding: ActivitySearchBinding) {
        searchViewModel.refreshState.observe(this@SearchActivity, Observer {
            binding.refresh.isRefreshing = it == NetworkState.LOADING
        })

        binding.refresh.setOnRefreshListener {
            searchViewModel.refresh()
        }
    }

}
