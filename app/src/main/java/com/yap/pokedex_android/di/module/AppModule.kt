package com.yap.pokedex_android.di.module

import com.google.gson.Gson
import com.yap.pokedex_android.AppExecutors
import com.yap.pokedex_android.PokeApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application : PokeApplication) : PokeApplication{
        return application
    }

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideAppExecutor() : AppExecutors {
        return AppExecutors()
    }


}