package com.example.photogallerypicker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("DEPRECATION") // = legacy in Windows
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnPicker: Button = findViewById(R.id.clicked_btn)
        val btnNext: Button = findViewById(R.id.btn_next)
        btnPicker.setOnClickListener {
            val intentGallery = Intent(Intent.ACTION_GET_CONTENT)
            intentGallery.type = "image/*" // this * = excel search fun family
            startActivityForResult(intentGallery, 101) // 101 as #ref

        }
        btnNext.setOnClickListener {
            startActivity(Intent(this,AnimalListViewActivity::class.java))
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == RESULT_OK && data != null) {
            val picSelected = data.data //to make copy from the photo already selected
            val imgPicked: ImageView = findViewById(R.id.picked_view)
            imgPicked.setImageURI(picSelected) //by URI to generate full quality for ImageView
        } else {
            // camera codes
        }
    }
}
            /*
            val intentCamera = Intent(Intent.ACTION_GET_CONTENT)
            intentCamera.type = "image/*" // this * looks like excel search fun family
            startActivityForResult(intentCamera, 101)
             */
     /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101) {
            //gallery codes
        } else if (requestCode == 500) {
            // camera codes
        }
        }
             */
    } */