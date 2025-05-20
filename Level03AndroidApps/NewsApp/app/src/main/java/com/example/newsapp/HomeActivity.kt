package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newsapp.databinding.ActivityHomeBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private var category = ""
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        MobileAds.initialize(this) {}
        loadAd()

        binding.techBtn.setOnClickListener {
            category = "technology"
            showAd()
        }
        binding.sportsBtn.setOnClickListener {
            category = "sports"
            showAd()
        }
        binding.scienceBtn.setOnClickListener {
            category = "science"
            showAd()
        }
        binding.toolBar.setOnMenuItemClickListener {
            if (it.itemId == R.id.settings_item){
                startActivity(Intent(this,SettingsActivity::class.java))
                true
            } else
                false

        }


    }

    private fun openNewsPage() {
        val i = Intent(this, MainActivity::class.java)
        i.putExtra("cat", category)
        startActivity(i)
    }

    private fun loadAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
    }

    private fun showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
            mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {

                override fun onAdDismissedFullScreenContent() {
                    mInterstitialAd = null
                    openNewsPage()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    mInterstitialAd = null
                    openNewsPage()
                }

            }
        } else {
            openNewsPage()
        }
    }
}