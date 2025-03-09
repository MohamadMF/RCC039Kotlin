package com.example.mediaplayerapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MediaPlayerActivity : AppCompatActivity() {
    lateinit var mediaSound: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media_player)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_media_player)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playBtn: Button = findViewById(R.id.play_btn)
        val pauseBtn: Button = findViewById(R.id.pause_btn)
        val stopBtn: Button = findViewById(R.id.stop_btn)
        mediaSound = MediaPlayer.create(this, R.raw.sound)


        playBtn.setOnClickListener { mediaSound.start() }
        pauseBtn.setOnClickListener { mediaSound.pause() }
        stopBtn.setOnClickListener {
            mediaSound.stop()
            mediaSound.prepareAsync()
            Toast.makeText(this,"You can now replay in clear",Toast.LENGTH_LONG).show()
        }
    }

    override fun onPause() {
        super.onPause()
        mediaSound.release()

    }
}