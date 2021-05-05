package com.example.retrofit.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Model.Article
import com.example.retrofit.Model.News
import com.example.retrofit.NewsService
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    val newsMutable : MutableLiveData<List<Article>> = MutableLiveData()

    fun getNews()
    {
        viewModelScope.launch {
            try {
                val response : List<News> = NewsService.newsInstance.getHeadlines("in", 1)
                newsMutable.value = response[0].articles

            } catch (e : Exception) {
                Log.d("getCall", "getPost: ${e.message}")
            }
        }
    }
}

