package com.yap.pokedex_android.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yap.pokedex_android.api.paging.`object`.PokemonVO
import com.yap.pokedex_android.util.NavigationUtil
import com.yarn.pokedex_android.databinding.ItemPokemonListBinding

class PokemonListAdapter(private val retryCallback : () -> Unit) : PagedListAdapter<PokemonVO, RecyclerView.ViewHolder>(POKE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(itemCount > position) {
            (holder as PokemonListViewHolder).binding.apply {
                pokemon = getItem(position)
                index = "${position + 1}."
                root.setOnClickListener {
                    NavigationUtil.startPokemonInfoActivity(it.context, position+1)
                }
            }
        }
    }

    companion object {
        val POKE_COMPARATOR = object : DiffUtil.ItemCallback<PokemonVO>() {
            override fun areItemsTheSame(oldItem: PokemonVO, newItem: PokemonVO): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: PokemonVO, newItem: PokemonVO): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class PokemonListViewHolder(var binding : ItemPokemonListBinding) : RecyclerView.ViewHolder(binding.root)

}