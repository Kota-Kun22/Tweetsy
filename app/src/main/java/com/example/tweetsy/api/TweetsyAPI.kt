package com.example.tweetsy.api

import com.example.tweetsy.models.TweetList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/65e4c54b266cfc3fde92bc59?meta=false")//this is dynamic
    suspend fun getTweets(@Header("X-JSON-Path") category:String):Response<List<TweetList>>//it is an async call all the https requests are the
    @GET("/v3/b/65e4c54b266cfc3fde92bc59?meta=false")
    @Headers("X-JSON-Path:tweets..category")//since it is static so here how it is implemented
    suspend fun getCategory():List<String>
}
