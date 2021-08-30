package com.deepak.hiltapplication.di

import android.content.Context
import androidx.room.Room
import com.deepak.hiltapplication.database.HiltDatabase
import com.deepak.hiltapplication.database.dao.BlogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Singleton
    @Provides
    fun provideBlogDB(@ApplicationContext context: Context): HiltDatabase {
        return Room.databaseBuilder(context, HiltDatabase::class.java, HiltDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }
    @Singleton
    @Provides
    fun provideBlogDAO(hiltDatabase: HiltDatabase):BlogDao{
        return hiltDatabase.blogDao()
    }


}