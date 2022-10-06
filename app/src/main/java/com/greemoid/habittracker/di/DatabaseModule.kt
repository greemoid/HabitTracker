package com.greemoid.habittracker.di

import android.content.Context
import androidx.room.Room
import com.greemoid.habittracker.data.cache.HabitDao
import com.greemoid.habittracker.data.cache.HabitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): HabitDatabase =
        Room.databaseBuilder(context, HabitDatabase::class.java, "habit_table.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Provides
    fun provideHabitDao(database: HabitDatabase): HabitDao =
        database.getHabitDao()

}