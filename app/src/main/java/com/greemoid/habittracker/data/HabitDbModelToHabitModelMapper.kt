package com.greemoid.habittracker.data

import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.domain.HabitModel

class HabitDbModelToHabitModelMapper : ListMapper<List<HabitDbModel>, List<HabitModel>> {
    override fun map(input: List<HabitDbModel>): List<HabitModel> {
        val list = mutableListOf<HabitModel>()
        input.forEach {
            list.add(HabitModel(
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
        return list
    }
}