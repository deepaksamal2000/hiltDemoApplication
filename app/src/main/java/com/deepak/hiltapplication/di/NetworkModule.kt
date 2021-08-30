package com.deepak.hiltapplication.di

import com.deepak.hiltapplication.network.BlogApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }
    @Impl1
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
    @Impl2
    @Singleton
    @Provides
    fun provideRetrofit2(gson: Gson):Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://b96daff9-32ee-49b6-abee-6d075fb47d72.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
    @Singleton
    @Provides
    fun provideBlogService(@Impl1 retrofit: Retrofit.Builder):BlogApi{
        return retrofit.build().create(BlogApi::class.java)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Impl1
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Impl2
}