package com.example.jankenkamadakotlin2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jankenkamadakotlin2.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTitleBinding
    @SuppressLint("SourceLockedOrientationActivity", "StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val countApp = CountApp()

        binding.gameCount.text = getString(R.string.total_result,countApp.getNumOfWins(),
        countApp.getNumOfLoses(),countApp.getNumOfDraws())

        binding.reset.setOnClickListener {
            CountApp().clearTotalResult()
            binding.gameCount.text = getString(R.string.total_result,countApp.getNumOfWins(),
                countApp.getNumOfLoses(),countApp.getNumOfDraws())
        }

        val intent = Intent(application,SelectActivity::class.java)
        binding.nextSean.setOnClickListener {
            startActivity(intent)
        }
    }
}