package com.greemoid.habittracker.presentation.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.usecases.GetAllHabitsUseCase
import com.greemoid.habittracker.presentation.date.CurrentDate
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TasksListViewModel @Inject constructor(
    private val getAllHabitsUseCase: GetAllHabitsUseCase,
    private val currentDate: CurrentDate,
) : ViewModel() {

    private val _liveData = MutableLiveData<List<HabitModel>>()
    val liveData: LiveData<List<HabitModel>> = _liveData

    fun getDayOfWeek(): Int {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    }

    fun getToday(): String {
        return currentDate.getCurrentDate()
    }

    fun getAllHabits() {
        Log.d("VIEWMODEL", getAllHabitsUseCase.getAllHabits().toString())
        _liveData.value = getAllHabitsUseCase.getAllHabits()
    }
}