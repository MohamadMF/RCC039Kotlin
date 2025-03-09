package com.example.kidsstories

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kidsstories.datasource.StoryArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_as_linear)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list: ListView = findViewById(R.id.stories_list)
        val btn: Button = findViewById(R.id.setting_btn)
        val arrayStory = StoryArray()

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayStory.titles)
        list.adapter = adapter

        btn.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        list.setOnItemClickListener { parent, view, position, id ->
            val i = Intent(this, StoryActivity::class.java)
            i.putExtra("title",arrayStory.titles[position])
            i.putExtra("story",arrayStory.stories[position])
            i.putExtra("picture",arrayStory.pictures[position])
            i.putExtra("sound",arrayStory.sounds[position])
            startActivity(i)
        }
    }
}