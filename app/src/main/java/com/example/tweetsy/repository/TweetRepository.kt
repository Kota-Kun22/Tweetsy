package com.example.tweetsy.repository
import retrofit2.Response;

import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.models.TweetList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI :TweetsyAPI) {
    private val _categories= MutableStateFlow<List<String>>(emptyList())//stateFLow
    val categories:StateFlow<List<String>>
        get()=_categories


    private val _tweets= MutableStateFlow<List<TweetList>>(emptyList())
    val tweets:StateFlow<List<String>>
        get()=_tweets
    suspend fun getCategories(){
        val reponse= tweetsyAPI.getCategory()
        if(reponse.isNotEmpty())
        {
            _categories.emit(reponse)
        }

    }


}