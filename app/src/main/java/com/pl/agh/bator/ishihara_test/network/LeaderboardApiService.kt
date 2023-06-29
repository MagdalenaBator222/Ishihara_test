package com.pl.agh.bator.ishihara_test.network

import com.pl.agh.bator.ishihara_test.LeaderboardScore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val SERVER_URL =
    "https://ishiharaleaderboard20230627170854.azurewebsites.net/"

// moshi instance for converting Json response to Kotlin objects
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(SERVER_URL)
    .build()

interface LeaderboardApiService {
    @GET("api/LeaderboardRecord/")
    suspend fun getLeaderboard() : List<LeaderboardScore>
}

object LeaderboardApi {
    val retrofitService : LeaderboardApiService by lazy {
        retrofit.create(LeaderboardApiService::class.java)
    }
}