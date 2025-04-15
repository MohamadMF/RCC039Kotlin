package com.example.basketballmission

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.basketballmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //make a copy from view model class
        val viewModel = ViewModelProvider(this)[ScoreViewModel::class.java]

        //make the clicked buttons show via MainActivity the scores by the observer
        viewModel.observerTeamA.observe(this) { newValue ->
            binding.scoreTeamA.text = "%,d".format(newValue)
        }
        viewModel.observerTeamB.observe(this) { newValue ->
            binding.scoreTeamB.text = "%,d".format(newValue)
        }

        //Section A
        binding.plus2TeamABtn.setOnClickListener {
            viewModel.makeTeamADoublePoints()
        }
        binding.plus3TeamABtn.setOnClickListener {
            viewModel.makeTeamATriplePoints()
        }
        binding.freeTeamABtn.setOnClickListener {
            viewModel.makeTeamAFreeThrow()
        }
        //-----------------------------------------

        //Section B
        binding.plus2TeamBBtn.setOnClickListener {
            viewModel.makeTeamBDoublePoints()
        }
        binding.plus3TeamBBtn.setOnClickListener {
            viewModel.makeTeamBTriplePoints()
        }
        binding.freeTeamBBtn.setOnClickListener {
            viewModel.makeTeamBFreeThrow()
        }
        //-----------------------------------------

        //Game Controller
        binding.endGameBtn.setOnClickListener {
            val scoreA = viewModel.liveScoreTeamA.value ?: 0
            val scoreB = viewModel.liveScoreTeamB.value ?: 0

            val winnerMessage = when {
                scoreA > scoreB -> "🏆 Team A Wins!"
                scoreB > scoreA -> "🏆 Team B Wins!"
                else -> "It's a Draw! 🤝"
            }

            // Show the result using a dialog
            AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage(winnerMessage)
                .setPositiveButton("OK") { _, _ -> }
                .show()

        }
        binding.resetBtn.setOnClickListener {
            viewModel.makeReset()
        }
    }
}