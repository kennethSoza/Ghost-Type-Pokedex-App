package edu.uca.ghostdex.di

import android.content.Context
import androidx.room.Room
import edu.uca.ghostdex.room.PkmnDao
import edu.uca.ghostdex.room.PkmnDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun providePkmnDb(@ApplicationContext context: Context): PkmnDatabase{
        return Room.databaseBuilder(context, PkmnDatabase::class.java, PkmnDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providePkmnDao(pkmnDatabase: PkmnDatabase): PkmnDao{
        return pkmnDatabase.pkmnDao()
    }
}