package com.greemoid.habittracker.presentation.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.usecases.UpdateHabitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(
    private val useCase: UpdateHabitUseCase,
): ViewModel() {

    fun update(habitModel: HabitModel) {
        viewModelScope.launch {
            useCase.updateHabit(habitModel)
        }
    }
}