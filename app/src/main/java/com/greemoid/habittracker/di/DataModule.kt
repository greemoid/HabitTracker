package com.greemoid.habittracker.di

import com.greemoid.habittracker.data.HabitCacheDataSource
import com.greemoid.habittracker.data.HabitDbModelToHabitModelMapper
import com.greemoid.habittracker.data.cache.HabitDao
import com.greemoid.habittracker.domain.HabitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideDataSource(habitDao: HabitDao): HabitRepository =
        HabitCacheDataSource(
            habitDao,
            HabitDbModelToHabitModelMapper()
        )
}