package com.example.weekendtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weekendtask.view.PostViewModel
import com.example.weekendtask.di.component.DaggerAppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var postViewModel:PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
        postViewModel.getPosts()
    }
}