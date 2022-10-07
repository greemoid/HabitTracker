package com.greemoid.habittracker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.usecases.AddHabitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val useCase: AddHabitUseCase,
) : ViewModel() {
    fun addHabit(habit: HabitModel) = viewModelScope.launch {
        useCase.addHabit(habit)
    }
}