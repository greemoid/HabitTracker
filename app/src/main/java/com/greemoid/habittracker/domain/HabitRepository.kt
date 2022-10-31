package com.greemoid.habittracker.domain

import androidx.lifecycle.LiveData
import com.greemoid.habittracker.data.cache.HabitDbModel

interface HabitRepository {
    fun getAllHabits(): LiveData<List<HabitDbModel>>
    suspend fun addHabit(habit: HabitModel)
    suspend fun updateHabit(habit: HabitDbModel)
    suspend fun deleteHabit(id: Int, habit: HabitDbModel)
}