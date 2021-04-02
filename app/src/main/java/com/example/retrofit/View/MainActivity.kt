package com.example.retrofit.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.ViewModel.GetNews
import com.example.retrofit.Model.News
import com.example.retrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GetNews().getNews()
    }

    fun setNews(news: News) {
        adapter = NewsAdapter(this@MainActivity, news.articles)
        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this@MainActivity)
    }
}