package com.deepak.hiltapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deepak.hiltapplication.database.Entities.BlogCacheEntity
import com.deepak.hiltapplication.database.dao.BlogDao

@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class HiltDatabase : RoomDatabase() {
    abstract fun blogDao(): BlogDao

    companion object {
        const val DATABASE_NAME: String = "blog_db"
    }
}