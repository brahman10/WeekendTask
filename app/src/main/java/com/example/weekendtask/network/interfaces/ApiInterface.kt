package com.example.weekendtask.network.interfaces

import com.google.gson.JsonArray
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts():Response<JsonArray>
}