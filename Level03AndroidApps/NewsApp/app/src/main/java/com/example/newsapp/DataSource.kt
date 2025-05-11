package com.example.newsapp

class News {
    val articles = listOf<Article>()
}

data class Article (
    val title: String = "",
    val url: String = "",
    val urlToImage: String = ""
)

