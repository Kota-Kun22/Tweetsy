package com.example.tweetsy.repository

import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.models.TweetList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import retrofit2.Response


class TweetRepository @Inject constructor(private val tweetsyAPI :TweetsyAPI) {
    private val _categories= MutableStateFlow<  List<String>  >(emptyList())//stateFLow
    val categories:StateFlow<List<String>>
        get()=_categories


    private val _tweets= MutableStateFlow<List<TweetList>>(emptyList())
    val tweets:StateFlow<List<TweetList>>
        get()=_tweets


    suspend fun getCategories(){
        val reponse= tweetsyAPI.getCategories()
        if(reponse.isSuccessful && reponse.body()!=null)
        {
            _categories.emit(reponse.body()!!)
        }

    }


    suspend fun getTweets(category:String){
        val reponse= tweetsyAPI.getTweets(category)
        if(reponse.isSuccessful && reponse.body()!=null)
        {
            _tweets.emit(reponse.body()!!)
        }

    }


}