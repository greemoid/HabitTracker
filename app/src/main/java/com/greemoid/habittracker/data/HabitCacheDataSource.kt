package com.greemoid.habittracker.data

import android.util.Log
import com.greemoid.habittracker.data.cache.HabitDao
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import javax.inject.Inject

class HabitCacheDataSource @Inject constructor(
    private val habitDao: HabitDao,
    private val mapper: HabitDbModelToHabitModelMapper,
) : HabitRepository {
    override fun getAllHabits(): List<HabitModel> {
        return mapper.map(habitDao.getAllHabits())
    }

    override suspend fun addHabit(habit: HabitModel) {
        habitDao.addHabit(habit.map())
    }

    override suspend fun updateHabit(habit: HabitModel) {
        Log.d("", "")
    }

    override suspend fun deleteHabit(habit: HabitModel) {
        Log.d("", "")
    }

}