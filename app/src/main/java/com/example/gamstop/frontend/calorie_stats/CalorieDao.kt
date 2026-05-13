package com.example.gamstop.frontend.calorie_stats

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalorieDao {
    @Query("SELECT * FROM calorie_records ORDER BY id DESC")
    suspend fun getAllRecords(): List<CalorieEntity>
    @Insert
    suspend fun insertRecord(record: CalorieEntity)
}