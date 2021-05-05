package com.example.retrofit.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.Model.Article
import com.example.retrofit.ViewModel.GetNews
import com.example.retrofit.Model.News
import com.example.retrofit.R
import com.example.retrofit.ViewModel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter: NewsAdapter = NewsAdapter()
    private lateinit var newsViewModel : NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}