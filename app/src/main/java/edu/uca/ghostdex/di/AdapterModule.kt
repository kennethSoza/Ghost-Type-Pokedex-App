package edu.uca.ghostdex.di

import android.app.Application
import edu.uca.ghostdex.utils.AdapterPkmn
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {
    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterPkmn{
        return AdapterPkmn()
    }
}