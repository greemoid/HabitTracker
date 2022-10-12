package com.greemoid.habittracker.domain

import androidx.lifecycle.LiveData

interface HabitRepository {
    fun getAllHabits(): LiveData<List<HabitModel>>
    suspend fun addHabit(habit: HabitModel)
    suspend fun updateHabit(habit: HabitModel)
    suspend fun deleteHabit(id: Int, habit: HabitModel)
}