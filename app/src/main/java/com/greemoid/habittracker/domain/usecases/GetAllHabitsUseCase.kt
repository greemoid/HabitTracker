package com.greemoid.habittracker.domain.usecases

import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import javax.inject.Inject

class GetAllHabitsUseCase @Inject constructor(
    private val repository: HabitRepository,
) {
    fun getAllHabits(): List<HabitModel> =
        repository.getAllHabits()
}