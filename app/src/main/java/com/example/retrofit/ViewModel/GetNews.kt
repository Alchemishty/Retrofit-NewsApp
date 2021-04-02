package com.example.retrofit.ViewModel

import android.util.Log
import com.example.retrofit.Model.News
import com.example.retrofit.NewsService
import com.example.retrofit.View.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetNews {
    public fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    //should call setNews here
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Debug", "Error in fetching news", t)
            }
        })
    }
}