package com.greemoid.habittracker.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greemoid.habittracker.data.cache.HabitDao
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.domain.HabitRepository
import java.util.*
import javax.inject.Inject

class HabitCacheDataSource @Inject constructor(
    private val habitDao: HabitDao,
    private val mapper: HabitDbModelToHabitModelMapper,
) : HabitRepository {
    override fun getAllHabits(): LiveData<List<HabitModel>> {
        /*val liveData = MutableLiveData<List<HabitModel>>()*/
        val liveData = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            1 -> mapper.map(habitDao.getSundayHabits())
            2 -> mapper.map(habitDao.getMondayHabits())
            3 -> mapper.map(habitDao.getTuesdayHabits())
            4 -> mapper.map(habitDao.getWednesdayHabits())
            5 -> mapper.map(habitDao.getThursdayHabits())
            6 -> mapper.map(habitDao.getFridayHabits())
            7 -> mapper.map(habitDao.getSaturdayHabits())
            else -> mapper.map(habitDao.getSaturdayHabits())
        }
        Log.d("SOURCE", liveData.value.toString())
        return liveData
    }

    override suspend fun addHabit(habit: HabitModel) {
        habitDao.addHabit(habit.map())
    }

    override suspend fun updateHabit(habit: HabitModel) {
        habitDao.updateHabit(habit.map())
    }

    override suspend fun deleteHabit(id: Int, habit: HabitModel) {
        habitDao.deleteHabit(habit.id)
    }

}