package com.example.weekendtask.repo

import com.example.weekendtask.network.interfaces.ApiInterface
import com.google.gson.JsonArray
import retrofit2.Response
import javax.inject.Inject

class PostRepository @Inject constructor( private val apiInterface: ApiInterface){

    suspend fun getPosts():Response<JsonArray>
    {
        return apiInterface.getPosts()
    }
}