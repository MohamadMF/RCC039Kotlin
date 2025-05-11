package com.example.newsapp

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ArticleListItemBinding


class ArticleAdapter(private val context: Activity, private val articles: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(val binding: ArticleListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ArticleViewHolder {
        return ArticleViewHolder(
            ArticleListItemBinding.inflate(
                context.layoutInflater,
                p0,
                false
            )
        )
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, p1: Int) {
        holder.binding.root.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, articles[p1].url.toUri())
            context.startActivity(i)
        }
        holder.binding.textArticle.text = articles[p1].title
        Glide
            .with(holder.binding.cardImg.context)
            .load(articles[p1].urlToImage)
            .error(R.drawable.baseline_broken_image_24)
            .into(holder.binding.cardImg)

        Log.d("trace", "Link: ${articles[p1].urlToImage}")
    }
}