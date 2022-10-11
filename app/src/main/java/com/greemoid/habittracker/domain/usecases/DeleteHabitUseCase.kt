package com.greemoid.habittracker.domain.usecases

import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import javax.inject.Inject

class DeleteHabitUseCase @Inject constructor(private val repository: HabitRepository) {
    suspend fun deleteHabit(habitModel: HabitModel) {
        repository.deleteHabit(habitModel.id, habitModel)
    }
}