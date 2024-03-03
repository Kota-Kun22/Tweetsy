package com.example.tweetsy.di

import com.example.tweetsy.api.TweetsyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    /**
     * interface k corresponding objects return kare ga basically (singletone object)
     * one for the retrofit object
     * one for the API object
     * */

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit
    {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    /**
     * retorfit ka object return kare ga
     * */



    @Singleton
    @Provides
    fun providesTweetsAPI(retrofit:Retrofit):TweetsyAPI{
        return retrofit.create(TweetsyAPI::class.java)
    }
    /**
     * creating API objects
     * */

}