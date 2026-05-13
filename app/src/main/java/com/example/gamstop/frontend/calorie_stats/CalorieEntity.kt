package com.example.gamstop.frontend.calorie_stats // Adjust if you renamed it!

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calorie_records")
data class CalorieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val time: String,
    val foodName: String,
    val calories: Int
)