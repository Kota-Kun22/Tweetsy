package com.example.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.repository.TweetRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val repository:TweetRepository):ViewModel() {
    val tweets :StateFlow<List<String>>
        get() = repository.categories
     init {
         viewModelScope.launch {
             repository.getTweets("motivation")
         }
     }
}