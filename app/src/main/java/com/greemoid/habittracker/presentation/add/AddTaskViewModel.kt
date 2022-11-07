package com.greemoid.habittracker.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.usecases.AddHabitUseCase
import com.greemoid.habittracker.presentation.date.CurrentDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val useCase: AddHabitUseCase,
) : ViewModel() {

    fun addHabit(habit: HabitDbModel) = viewModelScope.launch {
        useCase.addHabit(habit)
    }

}