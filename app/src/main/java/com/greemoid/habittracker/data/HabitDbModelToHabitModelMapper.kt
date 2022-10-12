package com.greemoid.habittracker.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.domain.HabitModel

class HabitDbModelToHabitModelMapper : ListMapper<LiveData<List<HabitDbModel>>, LiveData<List<HabitModel>>> {
    override fun map(input: LiveData<List<HabitDbModel>>): LiveData<List<HabitModel>> {
        val list = mutableListOf<HabitModel>()
        input.value?.forEach {
            list.add(HabitModel(
                it.id,
                it.title,
                it.icon,
                it.color,
                it.isDone,
                it.totallyDays,
                it.streakDays,
                it.doOnMonday,
                it.doOnTuesday,
                it.doOnWednesday,
                it.doOnThursday,
                it.doOnFriday,
                it.doOnSaturday,
                it.doOnSunday,
                it.partOfDay
            ))
        }
        return MutableLiveData(list)
    }
}