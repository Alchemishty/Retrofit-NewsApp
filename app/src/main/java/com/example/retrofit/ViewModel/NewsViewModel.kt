package com.example.retrofit.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Model.Article
import com.example.retrofit.Model.News
import com.example.retrofit.NewsService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    val newsMutable: MutableLiveData<List<Article>> = MutableLiveData()

    fun getNews() {
        viewModelScope.launch {
            val news = NewsService.newsInstance.getHeadlines("in", 1)
            news.enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    val news = response.body()
                    if (news != null) {
                        Log.d("testing", news.toString())
                        newsMutable.value = news.articles
                    }
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("Debug", "Error in fetching news", t)
                }
            })
        }
    }
}

