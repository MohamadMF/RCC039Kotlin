package com.example.mediaplayerapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MediaPlayerActivity : AppCompatActivity() {
    //Late Initialization = lateinit
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

        val playBtn: MaterialButton = findViewById(R.id.play_btn)
        val pauseBtn: MaterialButton = findViewById(R.id.pause_btn)
        val stopBtn: MaterialButton = findViewById(R.id.stop_btn)
        mediaSound = MediaPlayer.create(this, R.raw.sound)

//        var isPlayed = false // it must be out of listener body to effect
        playBtn.setOnClickListener { mediaSound.start() }
//        playBtn.setOnClickListener {
//            if (!isPlayed) {
//                mediaSound.start()
//                isPlayed = true
//                playBtn.text = "Pause"
//                playBtn.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_media_pause)
//            } else {
//                mediaSound.pause()
//                isPlayed = false
//                playBtn.text = "Play"
//                playBtn.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_media_play)
//
//            }
//
//        }

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