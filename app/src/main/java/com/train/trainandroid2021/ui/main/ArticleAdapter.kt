package com.train.trainandroid2021.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.train.trainandroid2021.databinding.ViewHolderNewsBinding
import com.train.trainandroid2021.repository.model.Article
import kotlin.properties.Delegates

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    var articles: List<Article> by Delegates.observable(listOf()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderNewsBinding.inflate(layoutInflater)

        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = articles[position]
        holder.binding.data = data
    }

    override fun getItemCount(): Int = articles.size

    class ArticleViewHolder(val binding: ViewHolderNewsBinding) :
        RecyclerView.ViewHolder(binding.root)
}