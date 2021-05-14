package com.example.weekendtask.di.component

import com.example.weekendtask.MainActivity
import com.example.weekendtask.di.module.NetworkModule
import com.example.weekendtask.di.module.PostDatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [NetworkModule::class,PostDatabaseModule::class])
@Singleton
interface AppComponent  {

    fun inject(mainActivity: MainActivity)

//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: App): Builder
//
//        fun build(): AppComponent
//    }
}