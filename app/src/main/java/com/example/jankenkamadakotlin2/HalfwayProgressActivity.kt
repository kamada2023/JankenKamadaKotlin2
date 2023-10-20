package com.example.jankenkamadakotlin2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jankenkamadakotlin2.databinding.ActivityHalfwayBinding

class HalfwayProgressActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHalfwayBinding
    @SuppressLint("StringFormatMatches", "SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalfwayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val battleCount:Int = CountApp().getCount()
        val countWin:Int = CountApp().getWinCount()
        val countLose:Int = CountApp().getLoseCount()
        val countDraw:Int = CountApp().getDrawCount()

        binding.battleCount.text = getString(R.string.halfway_sub,battleCount)

        binding.countWin.text = getString(R.string.win_count,countWin)
        binding.countLose.text = getString(R.string.lose_count,countLose)
        binding.countDraw.text = getString(R.string.draw_count,countDraw)

        val intent = Intent(application,MainActivity::class.java)
        binding.nextBattle.setOnClickListener {
            startActivity(intent)
        }
    }

}