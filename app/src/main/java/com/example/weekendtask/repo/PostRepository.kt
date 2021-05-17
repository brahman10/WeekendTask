package com.example.weekendtask.repo

import android.util.Log
import com.example.weekendtask.db.PostDao
import com.example.weekendtask.network.interfaces.ApiInterface
import com.google.gson.JsonArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PostRepository @Inject constructor( private val apiInterface: ApiInterface , private val postDao: PostDao){

    suspend fun getPosts():Response<JsonArray>
    {
        return apiInterface.getPosts()
    }

    suspend fun getPostsFromDatabase():List<Posts>
    {
        var list :List<Posts>?=null
        withContext(Dispatchers.IO)
        {
             list =postDao.getAllPosts()
        }
        return list!!
    }

    suspend fun insertData(list: List<Posts>)
    {
        for (post in list) {
            postDao.addNote(post)
            Log.e("Data","${post.id} \n Inserted Successfully")
        }
    }

//    suspend fun getPostsFromDatabasePaging(): LiveData<PagedList<Posts>>
//    {
//        var list :LiveData<PagedList<Posts>>
//        withContext(Dispatchers.Main)
//        {
//            list =postDao.getAllPostsPaging().toLiveData(pageSize = 10)
//            if(list!=null)
//            {
//                for (post in list.value!!)
//                {
//                    Log.e("dataa","${post.title}")
//                }
//            }
//            else
//            {
//                Log.e("dataa","Null h bro")
//            }
//        }
//        return list!!
//    }
}