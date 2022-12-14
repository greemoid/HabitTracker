package com.greemoid.habittracker.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HabitDbModel::class], version = 2)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun getHabitDao(): HabitDao
}