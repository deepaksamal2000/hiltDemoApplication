package com.deepak.hiltapplication.di

import com.deepak.hiltapplication.database.dao.BlogDao
import com.deepak.hiltapplication.network.BlogApi
import com.deepak.hiltapplication.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao, blogApi: BlogApi
    ): MainRepository {
        return MainRepository(blogDao, blogApi)
    }
}