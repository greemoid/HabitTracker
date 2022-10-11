package com.greemoid.habittracker.di

import com.greemoid.habittracker.presentation.date.CurrentDate
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideCurrentDate(): CurrentDate =
        CurrentDate.Base()
}