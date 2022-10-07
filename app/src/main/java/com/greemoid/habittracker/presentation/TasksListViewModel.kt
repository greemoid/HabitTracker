package com.greemoid.habittracker.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.usecases.GetAllHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksListViewModel @Inject constructor(
    private val getAllHabitsUseCase: GetAllHabitsUseCase,
) : ViewModel() {

    private val _liveData = MutableLiveData<List<HabitModel>>()
    val liveData: LiveData<List<HabitModel>> = _liveData

    fun getAllHabits() {
        Log.d("VIEWMODEL", getAllHabitsUseCase.getAllHabits().toString())
        _liveData.value = getAllHabitsUseCase.getAllHabits()
    }
}