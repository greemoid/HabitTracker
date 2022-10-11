package com.greemoid.habittracker.domain

import com.greemoid.habittracker.data.Mapper
import com.greemoid.habittracker.data.cache.HabitDbModel
import java.io.Serializable

data class HabitModel(
    val id: Int,
    val title: String,
    val icon: String,
    val color: String,
    val isDone: Boolean,
    val totallyDays: Int,
    val streakDays: Int,
    val doOnMonday: Boolean,
    val doOnTuesday: Boolean,
    val doOnWednesday: Boolean,
    val doOnThursday: Boolean,
    val doOnFriday: Boolean,
    val doOnSaturday: Boolean,
    val doOnSunday: Boolean,
    val partOfDay: String,
) : Mapper<HabitDbModel>, Serializable {
    override fun map(): HabitDbModel =
        HabitDbModel(
            id = id,
            title = title,
            icon = icon,
            color = color,
            isDone = isDone,
            totallyDays = totallyDays,
            streakDays = streakDays,
            doOnMonday = doOnMonday,
            doOnTuesday = doOnTuesday,
            doOnWednesday = doOnWednesday,
            doOnThursday = doOnThursday,
            doOnFriday = doOnFriday,
            doOnSaturday = doOnSaturday,
            doOnSunday = doOnSunday,
            partOfDay = partOfDay
        )

    fun fetchTitle() = title
}
