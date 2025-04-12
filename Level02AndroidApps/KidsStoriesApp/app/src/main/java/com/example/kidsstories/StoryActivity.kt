package com.example.kidsstories

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val titleTxtVw: TextView = findViewById(R.id.story_title)
        val storyTxtVw: TextView = findViewById(R.id.story_details)
        val storyImg: ImageView = findViewById(R.id.story_image)

        titleTxtVw.text = intent.getStringExtra("title")
        storyTxtVw.text = intent.getStringExtra("story")
        storyImg.setImageResource(intent.getIntExtra("picture",-2))

        MediaPlayer //companion object
            .create(this,intent.getIntExtra("sound",-1))
            .start()

        val pref = getSharedPreferences("settings", MODE_PRIVATE)
        val newSize = pref.getInt("size",20).toFloat()
        titleTxtVw.textSize = newSize + 8
        storyTxtVw.textSize = newSize
    }
}