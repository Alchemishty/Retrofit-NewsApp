package com.example.retrofit.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.Model.Article
import com.example.retrofit.View.ArticleActivity
import com.example.retrofit.databinding.ArticleItemBinding

class NewsAdapter(val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    lateinit var binding: ArticleItemBinding

    private var articleList = mutableListOf<Article>()

    fun setData(articleList: List<Article>) {
        this.articleList = articleList as MutableList<Article>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = ArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articleList[position]
        binding.newsTitle.text = article.title
        binding.newsDescription.text = article.description
        Glide.with(binding.newsImage).load(article.urlToImage).into(binding.newsImage)
        holder.itemView.setOnClickListener {

            val intent = Intent(this.context, ArticleActivity::class.java)

            intent.putExtra("ARTICLE_TITLE", article.title)
            intent.putExtra("ARTICLE_DESCRIPTION", article.description)
            intent.putExtra("ARTICLE_IMAGE", article.urlToImage)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

}