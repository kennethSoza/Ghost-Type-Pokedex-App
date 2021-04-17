package edu.uca.ghostdex.room
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PkmnDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: PkmnCacheEntity): Long
    @Query("select * from pokemon")
    suspend fun get(): List<PkmnCacheEntity>
}