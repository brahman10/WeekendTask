package com.example.weekendtask

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekendtask.databinding.ActivityMainBinding
import com.example.weekendtask.view.PostAdapter
import com.example.weekendtask.view.PostViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var postViewModel:PostViewModel
    @Inject
    lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.myAdapter=postAdapter

        postViewModel.getPostsFromDatabasePaging()
        postViewModel.postListFromDB.observe(this, Observer {
            if (it!=null) {
                val list =it.snapshot()
                postAdapter.setPostList(list)
                if (list!=null)
                {
                    for (a in list)
                    {
                        if (a!=null)
                        {
                            Log.e("Dataa","${a.id} ")
                        }
                    }
                }

            }
        })
    }
}