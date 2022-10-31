package com.greemoid.habittracker.domain.usecases

import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import javax.inject.Inject

class UpdateHabitUseCase @Inject constructor(private val repository: HabitRepository) {
    suspend fun updateHabit(habitModel: HabitDbModel){
        repository.updateHabit(habitModel)
    }
}