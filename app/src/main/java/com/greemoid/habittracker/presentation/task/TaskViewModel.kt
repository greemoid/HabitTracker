package com.greemoid.habittracker.presentation.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.usecases.DeleteHabitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val useCase: DeleteHabitUseCase,
) : ViewModel() {
    fun deleteHabit(habitModel: HabitDbModel) {
        viewModelScope.launch {
            useCase.deleteHabit(habitModel)
        }
    }
}