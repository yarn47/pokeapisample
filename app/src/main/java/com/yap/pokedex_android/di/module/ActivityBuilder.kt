package com.yap.pokedex_android.di.module

import com.yap.pokedex_android.ui.SplashActivity
import com.yap.pokedex_android.ui.search.SearchActivity
import com.yap.pokedex_android.ui.search.module.SearchModule
import com.yap.pokedex_android.ui.search.viewmodel.SearchViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity() : SplashActivity

    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun contributeSearchActivity() : SearchActivity
}