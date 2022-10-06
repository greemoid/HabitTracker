package com.greemoid.habittracker.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
class HabitDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val title: String,
    @ColumnInfo val icon: String,
    @ColumnInfo val color: String,
    @ColumnInfo val doOnMonday: Boolean,
    @ColumnInfo val doOnTuesday: Boolean,
    @ColumnInfo val doOnWednesday: Boolean,
    @ColumnInfo val doOnThursday: Boolean,
    @ColumnInfo val doOnFriday: Boolean,
    @ColumnInfo val doOnSaturday: Boolean,
    @ColumnInfo val doOnSunday: Boolean,
    @ColumnInfo val partOfDay: String,
)