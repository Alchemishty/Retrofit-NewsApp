package com.example.retrofit.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.Model.Article
import com.example.retrofit.databinding.ItemsBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(val binding: ItemsBinding):RecyclerView.ViewHolder(binding.root)

    lateinit var binding: ItemsBinding

    private var articleList = mutableListOf<Article>()

    fun setData(articleList: List<Article>) {
        this.articleList = articleList as MutableList<Article>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articleList[position]
        binding.newsTitle.text = article.title
        binding.newsDescription.text = article.description
        Glide.with(binding.newsImage).load(article.urlToImage).into(binding.newsImage)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

}