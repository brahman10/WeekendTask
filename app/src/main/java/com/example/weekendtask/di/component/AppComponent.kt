package com.example.weekendtask.di.component

import com.example.weekendtask.App
import com.example.weekendtask.MainActivity
import com.example.weekendtask.di.module.AppModule
import com.example.weekendtask.di.module.NetworkModule
import com.example.weekendtask.di.module.PostDatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class,NetworkModule::class,PostDatabaseModule::class,AppModule::class])
@Singleton
interface AppComponent :AndroidInjector<App> {

    override fun inject(app: App)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }
}