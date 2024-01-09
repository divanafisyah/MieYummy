package com.example.admin.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MieYummyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mieYummy: MieYummy)

    @Update
    suspend fun update(mieYummy: MieYummy)

    @Delete
    suspend fun delete(mieYummy: MieYummy)

    @Query("SELECT * from tblMie WHERE id = :id")
    fun getMie(id: Int): Flow<MieYummy>


    @Query("SELECT * from tblMie ORDER BY jenis ASC")
    fun getAllMie(): Flow<List<MieYummy>>

}