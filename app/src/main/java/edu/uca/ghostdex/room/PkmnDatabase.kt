package edu.uca.ghostdex.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PkmnCacheEntity::class], version = 1)
abstract class PkmnDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "PkmnGhostDB"
    }
    abstract fun pkmnDao() : PkmnDao
}