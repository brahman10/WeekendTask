package com.example.weekendtask.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.weekendtask.repo.Posts

@Dao
interface PostDao {

    @Insert
    fun addNote(post:Posts)

    @Query("Select * from posts")
    fun getAllPosts():List<Posts>


}