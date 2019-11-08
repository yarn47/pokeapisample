package com.yap.pokedex_android

import com.yap.pokedex_android.common.BaseApplication
import com.yap.pokedex_android.di.component.DaggerPokeComponent
import dagger.android.AndroidInjector

class PokeApplication : BaseApplication() {

    companion object {
        @get:Synchronized
        lateinit var instance : PokeApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out BaseApplication> {
        return DaggerPokeComponent.builder().create(this)
    }
}