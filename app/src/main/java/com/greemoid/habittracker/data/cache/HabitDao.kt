package com.greemoid.habittracker.data.cache

import androidx.room.*

@Dao
interface HabitDao {

    @Query("SELECT * FROM habit_table")
    fun getAllHabits(): List<HabitDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHabit(habit: HabitDbModel)

    @Update
    suspend fun updateHabit(habit: HabitDbModel)

    @Delete
    suspend fun deleteHabit(habit: HabitDbModel)
}