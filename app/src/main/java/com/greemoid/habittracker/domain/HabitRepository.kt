package com.greemoid.habittracker.domain

interface HabitRepository {
    fun getAllHabits(): List<HabitModel>
    suspend fun addHabit(habit: HabitModel)
    suspend fun updateHabit(habit: HabitModel)
    suspend fun deleteHabit(id: Int, habit: HabitModel)
}