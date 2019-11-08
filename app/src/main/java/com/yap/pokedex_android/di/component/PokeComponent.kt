package com.yap.pokedex_android.di.component

import com.yap.pokedex_android.PokeApplication
import com.yap.pokedex_android.di.module.ActivityBuilder
import com.yap.pokedex_android.di.module.AppModule
import com.yap.pokedex_android.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class,
    AppModule::class, NetworkModule::class])
interface PokeComponent : AndroidInjector<PokeApplication> {

    @Component.Builder
    abstract class builder : AndroidInjector.Builder<PokeApplication>()
}