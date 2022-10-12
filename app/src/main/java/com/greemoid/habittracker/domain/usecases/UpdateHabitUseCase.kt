package com.greemoid.habittracker.domain.usecases

import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import javax.inject.Inject

class UpdateHabitUseCase @Inject constructor(private val repository: HabitRepository) {
    suspend fun updateHabit(habitModel: HabitModel){
        repository.updateHabit(habitModel)
    }
}