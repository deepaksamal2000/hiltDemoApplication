package com.deepak.hiltapplication.repository

import com.deepak.hiltapplication.database.Entities.BlogCacheEntity
import com.deepak.hiltapplication.database.dao.BlogDao
import com.deepak.hiltapplication.network.BlogApi
import javax.inject.Inject

class MainRepository

constructor(
    private val blogDao: BlogDao,
    private val blogApi: BlogApi
)
{
    fun getDummyTest():String{
        return "Deepak"
    }
    suspend fun saveDummyData():Long{
        val blogCacheEntity=BlogCacheEntity(1,"Deepak","","","")
        return blogDao.insert(blogCacheEntity)
    }
    suspend fun getBlogs():String{
        return blogApi.get().toString()
    }
}