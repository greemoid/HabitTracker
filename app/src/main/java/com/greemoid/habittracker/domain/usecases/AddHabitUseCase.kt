package com.greemoid.habittracker.domain.usecases

import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import javax.inject.Inject

class AddHabitUseCase @Inject constructor(
    private val repository: HabitRepository,
) {
    suspend fun addHabit(habit: HabitModel) =
        repository.addHabit(habit)
}