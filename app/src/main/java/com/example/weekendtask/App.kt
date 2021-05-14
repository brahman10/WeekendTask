package com.example.weekendtask

//import android.app.Activity
//import android.content.Context
//import android.os.Bundle
//import com.example.weekendtask.di.component.DaggerAppComponent
//import dagger.android.AndroidInjector
//import dagger.android.DaggerApplication
//import javax.inject.Inject
//
//class App : DaggerApplication() {
//
//
//    override fun attachBaseContext(base: Context?) {
//        super.attachBaseContext(base)
//
//    }
//
//    companion object {
//        private var context: Context? = null
//        fun getApplicationContext(): Context? {
//            return context
//        }
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        context = applicationContext
//
//        /* Get Current Activity Callback */
//        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
//            override fun onActivityPaused(activity: Activity) {
//            }
//
//            override fun onActivityStarted(activity: Activity) {
//            }
//
//            override fun onActivityDestroyed(activity: Activity) {
//            }
//
//            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
//            }
//
//            override fun onActivityStopped(activity: Activity) {
//            }
//
//            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
//            }
//
//            override fun onActivityResumed(activity: Activity) {
//            }
//        })
//
//    }
//
//    override fun applicationInjector(): AndroidInjector<out DaggerApplication?> {
//        return DaggerAppComponent.builder().application(this).build()
//    }
//
//}