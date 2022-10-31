package com.greemoid.habittracker.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "habit_table")
data class HabitDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val title: String,
    @ColumnInfo val icon: String,
    @ColumnInfo val color: String,
    @ColumnInfo val date: String,
    @ColumnInfo val totallyDays: Int,
    @ColumnInfo val streakDays: Int,
    @ColumnInfo val doOnMonday: Boolean,
    @ColumnInfo val doOnTuesday: Boolean,
    @ColumnInfo val doOnWednesday: Boolean,
    @ColumnInfo val doOnThursday: Boolean,
    @ColumnInfo val doOnFriday: Boolean,
    @ColumnInfo val doOnSaturday: Boolean,
    @ColumnInfo val doOnSunday: Boolean,
    @ColumnInfo val partOfDay: String,
) : Serializable