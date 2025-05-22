package com.maad.newsadminmaad

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.maad.newsadminmaad.databinding.ActivityDetailsBinding
import java.util.Calendar

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private var picUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val handler = registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) {
            picUri = it
            binding.imageBtn.setImageURI(it)
        }
        binding.imageBtn.setOnClickListener {
            handler.launch("image/*")
        }

        binding.doneImage.setOnClickListener {
            addArticle()
        }


    }

    @SuppressLint("SuspiciousIndentation")
    private fun uploadPicture() {
        //Date Time class as kotlin library

        //Java Calender library
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val minute = cal.get(Calendar.MINUTE)
        val second = cal.get(Calendar.SECOND)
        val millis = cal.get(Calendar.MILLISECOND)
        val picFormat = "$year-$month-$day $hour:$minute:$second.$millis"

        val pic = Firebase.storage.reference.child(picFormat)
            pic.putFile(picUri!!).addOnSuccessListener {
                pic.downloadUrl.addOnSuccessListener {
                    Log.d("trace", "picLink:$it")
                }
        }
    }

    private fun addArticle() {
        binding.loadingProgress.isVisible = true
        trackProgress("Please wait...",20)

        val title = binding.titleEt.text.toString()
        val description = binding.descriptionEt.text.toString()
        val a = Article(title, description)

        val db = Firebase.firestore
        db
            .collection("articles")
            .add(a)
            .addOnSuccessListener {
                trackProgress("Uploading...",60)
                it.update("id", it.id).addOnSuccessListener {
                    Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show()
                    trackProgress("Done!", 100)
                }
            }
    }

    private fun trackProgress(text: String, period: Int) {
        binding.progressTv.text = text
        binding.loadingProgress.progress = period
    }

}