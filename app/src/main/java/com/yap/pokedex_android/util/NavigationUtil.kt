package com.yap.pokedex_android.util

import android.content.Context
import android.content.Intent
import com.yap.pokedex_android.PokeApplication
import com.yap.pokedex_android.common.Const
import com.yap.pokedex_android.ui.pokemon.PokemonInfoActivity
import javax.inject.Inject

object NavigationUtil {

    fun startPokemonInfoActivity(context : Context, index : Int) {
        val intent = Intent(context, PokemonInfoActivity::class.java).apply {
            putExtra(Const.POKE_INDEX, index)
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
        context.startActivity(intent)

    }

    fun startPokemonInfoActivity(context : Context, name : String) {
        val intent = Intent(context, PokemonInfoActivity::class.java).apply {
            putExtra(Const.POKE_NAME, name)
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
        context.startActivity(intent)
    }

}