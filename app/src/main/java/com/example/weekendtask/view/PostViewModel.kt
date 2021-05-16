package com.example.weekendtask.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.example.weekendtask.db.PostDao
import com.example.weekendtask.repo.Posts
import com.example.weekendtask.repo.PostRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PostViewModel @Inject constructor(private val postRepository: PostRepository):ViewModel(){

    var postList = MutableLiveData<List<Posts>>()
    lateinit var postListFromDB : LiveData<PagedList<Posts>>
    fun getPosts()
    {
        viewModelScope.launch {
            val apiResponse = postRepository.getPosts()
            Log.e("Response",apiResponse.toString())
            when (apiResponse.code()) {

                /* Success */
                in (200..299) ->
                {
                    val gson = Gson()
                    val type = object : TypeToken<List<Posts?>?>() {}.type
                    val contactList: List<Posts> = gson.fromJson(apiResponse.body(), type)
                    postList.value= contactList
                    withContext(Dispatchers.IO)
                    {
                        postRepository.insertData(postList.value!!)
                    }

                }

                else -> {

                }
            }
        }
    }


    fun getPostsFromDatabase()
    {
        viewModelScope.launch {
            postList.value = postRepository.getPostsFromDatabase()

            for (post in postList.value!!)
            {
                Log.e("Data from Room","${post.id} \n")
            }
        }
    }

    fun getPostsFromDatabasePaging()
    {
        viewModelScope.launch {
            postListFromDB = postRepository.getPostsFromDatabasePaging()
//            for (post in postListFromDB.)
//            {
//                Log.e("Data from Room","${post.id} \n")
//            }
        }
    }
}