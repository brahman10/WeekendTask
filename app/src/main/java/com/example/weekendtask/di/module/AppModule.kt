package com.example.weekendtask.di.module

import com.example.weekendtask.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun mainActivity():MainActivity
}