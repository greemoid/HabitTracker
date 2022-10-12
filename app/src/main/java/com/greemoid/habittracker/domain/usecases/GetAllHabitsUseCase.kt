package com.greemoid.habittracker.domain.usecases

import androidx.lifecycle.LiveData
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import javax.inject.Inject

class GetAllHabitsUseCase @Inject constructor(
    private val repository: HabitRepository,
) {
    fun getAllHabits(): LiveData<List<HabitModel>> =
        repository.getAllHabits()
}