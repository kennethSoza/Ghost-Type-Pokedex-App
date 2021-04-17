package edu.uca.ghostdex.di

import edu.uca.ghostdex.repository.PkmnRepository
import  edu.uca.ghostdex.retrofit.NetworkMapper
import edu.uca.ghostdex.retrofit.PkmnRetrofit
import edu.uca.ghostdex.room.CacheMapper
import edu.uca.ghostdex.room.PkmnDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent :: class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePkmnRepository(
        pkmnDao: PkmnDao,
        pkmnRetrofit: PkmnRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): PkmnRepository {
        return PkmnRepository(pkmnDao, pkmnRetrofit, cacheMapper, networkMapper)
    }
}