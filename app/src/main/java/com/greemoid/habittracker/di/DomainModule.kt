package com.greemoid.habittracker.di

import com.greemoid.habittracker.domain.HabitRepository
import com.greemoid.habittracker.domain.usecases.AddHabitUseCase
import com.greemoid.habittracker.domain.usecases.DeleteHabitUseCase
import com.greemoid.habittracker.domain.usecases.GetAllHabitsUseCase
import com.greemoid.habittracker.domain.usecases.UpdateHabitUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideAddHabitUseCase(repository: HabitRepository) =
        AddHabitUseCase(repository)

    @Provides
    fun provideGetAllHabitsUseCase(repository: HabitRepository) =
        GetAllHabitsUseCase(repository)

    @Provides
    fun provideDeleteHabitUseCase(repository: HabitRepository) =
        DeleteHabitUseCase(repository)

    @Provides
    fun provideUpdateHabitUseCase(repository: HabitRepository) =
        UpdateHabitUseCase(repository)
}