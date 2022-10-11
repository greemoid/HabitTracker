package com.greemoid.habittracker.data.cache

import androidx.room.*

@Dao
interface HabitDao {

    @Query("SELECT * FROM habit_table WHERE doOnSunday = 1")
    fun getSundayHabits(): List<HabitDbModel>

    @Query("SELECT * FROM habit_table WHERE doOnMonday = 1")
    fun getMondayHabits(): List<HabitDbModel>

    @Query("SELECT * FROM habit_table WHERE doOnTuesday = 1")
    fun getTuesdayHabits(): List<HabitDbModel>

    @Query("SELECT * FROM habit_table WHERE doOnWednesday = 1")
    fun getWednesdayHabits(): List<HabitDbModel>

    @Query("SELECT * FROM habit_table WHERE doOnThursday = 1")
    fun getThursdayHabits(): List<HabitDbModel>

    @Query("SELECT * FROM habit_table WHERE doOnFriday = 1")
    fun getFridayHabits(): List<HabitDbModel>

    @Query("SELECT * FROM habit_table WHERE doOnSaturday = 1")
    fun getSaturdayHabits(): List<HabitDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHabit(habit: HabitDbModel)

    @Update
    suspend fun updateHabit(habit: HabitDbModel)

    @Query("DELETE FROM habit_table WHERE id = :id")
    suspend fun deleteHabit(id: Int)
}