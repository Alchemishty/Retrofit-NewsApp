package com.example.retrofit.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.retrofit.R

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val articleTitle = intent.getStringExtra("ARTICLE_TITLE")
        val articleDescription = intent.getStringExtra("ARTICLE_DESCRIPTION")
        val articleImage = intent.getStringExtra("ARTICLE_IMAGE")

        var tvArticleTitle = findViewById<TextView>(R.id.articleTitle)
        var tvArticleDescription = findViewById<TextView>(R.id.articleDescription)
        var tvArticleImage = findViewById<ImageView>(R.id.articleImage)

        tvArticleTitle.text = articleTitle
        tvArticleDescription.text = articleDescription
        Glide.with(this).load(articleImage).into(tvArticleImage)
    }
}