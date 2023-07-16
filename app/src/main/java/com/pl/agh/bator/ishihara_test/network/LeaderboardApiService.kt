package com.pl.agh.bator.ishihara_test.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

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

    @POST("api/LeaderboardRecord/")
    suspend fun addRecord(@Body requestBody: ResponseScore) : Response<ResponseBody>
}

object LeaderboardApi {
    val retrofitService : LeaderboardApiService by lazy {
        retrofit.create(LeaderboardApiService::class.java)
    }
}