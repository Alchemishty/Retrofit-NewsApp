package com.example.retrofit.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Adapter.NewsAdapter
import com.example.retrofit.R
import com.example.retrofit.ViewModel.NewsViewModel

class MainActivity : AppCompatActivity() {

    var newsAdapter: NewsAdapter = NewsAdapter(this)
    private lateinit var newsViewModel : NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsList : RecyclerView = findViewById(R.id.newsList)
        newsList.adapter = newsAdapter
        newsList.layoutManager = LinearLayoutManager(this)

        newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        newsViewModel.getNews()
        newsViewModel.newsMutable.observe(this, {
            newsAdapter.setData(it)
            Log.d("setdata", "Data has been changed")
        })
    }

}