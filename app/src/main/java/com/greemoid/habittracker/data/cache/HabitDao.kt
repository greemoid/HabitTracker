package com.greemoid.habittracker.data.cache

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HabitDao {

    @Query("SELECT * FROM habit_table WHERE doOnSunday = 1")
    fun getSundayHabits(): LiveData<List<HabitDbModel>>

    @Query("SELECT * FROM habit_table WHERE doOnMonday = 1")
    fun getMondayHabits(): LiveData<List<HabitDbModel>>

    @Query("SELECT * FROM habit_table WHERE doOnTuesday = 1")
    fun getTuesdayHabits(): LiveData<List<HabitDbModel>>

    @Query("SELECT * FROM habit_table WHERE doOnWednesday = 1")
    fun getWednesdayHabits(): LiveData<List<HabitDbModel>>

    @Query("SELECT * FROM habit_table WHERE doOnThursday = 1")
    fun getThursdayHabits(): LiveData<List<HabitDbModel>>

    @Query("SELECT * FROM habit_table WHERE doOnFriday = 1")
    fun getFridayHabits(): LiveData<List<HabitDbModel>>

    @Query("SELECT * FROM habit_table WHERE doOnSaturday = 1")
    fun getSaturdayHabits(): LiveData<List<HabitDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHabit(habit: HabitDbModel)

    @Update
    suspend fun updateHabit(habit: HabitDbModel)

    @Query("DELETE FROM habit_table WHERE id = :id")
    suspend fun deleteHabit(id: Int)
}