package com.maad.newsadminmaad

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage
import com.maad.newsadminmaad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.addFab.setOnClickListener {
            startActivity(Intent(this, DetailsActivity::class.java))
        }

        prepareSwipeToDelete()
    }

    override fun onResume() {
        super.onResume()
        getFirebaseArticles()
    }

    private fun getFirebaseArticles() {
        Firebase
            .firestore
            .collection("articles")
            .get()
            .addOnSuccessListener {
                val article = it.toObjects(Article::class.java)
                val adapter = ArticleAdapter(this, article)
                binding.newsRv.adapter = adapter
                binding.loadingProgress.isVisible = false
            }
    }

    private fun prepareSwipeToDelete() {
        val helper = object : ItemTouchHelper
                .SimpleCallback(0,
                    ItemTouchHelper.START or ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder,
                                  direction: Int) {
                TODO("Not yet implemented")
            }

        }
        ItemTouchHelper(helper).attachToRecyclerView(binding.newsRv)
    }

    private fun deleteDocument(position: Int) {

    }

    private fun deleteImage(imageUrL: String, position: Int) {

    }

}