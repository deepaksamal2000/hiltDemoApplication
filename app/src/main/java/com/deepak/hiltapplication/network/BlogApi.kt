package com.deepak.hiltapplication.network

import retrofit2.http.GET

interface BlogApi {
    @GET("blogs")
    suspend fun get():List<BlogObjectResponse>
    @GET("data")
    suspend fun getdata():BlogObjectResponse
}