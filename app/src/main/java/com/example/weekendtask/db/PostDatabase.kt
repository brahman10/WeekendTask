package com.example.weekendtask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weekendtask.repo.Posts


@Database(entities = [Posts::class],version = 1)
abstract class PostDatabase : RoomDatabase(){

    abstract fun getPostDao():PostDao

}