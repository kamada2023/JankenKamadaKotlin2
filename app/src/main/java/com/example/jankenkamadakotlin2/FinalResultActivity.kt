package com.example.jankenkamadakotlin2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jankenkamadakotlin2.databinding.ActivityFinalresultBinding

class FinalResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFinalresultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalresultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countWin:Int = CountApp().getWinCount()
        val countLose:Int = CountApp().getLoseCount()
        val countDraw:Int = CountApp().getDrawCount()

        if (countWin > countLose){
            binding.resultDrawFinal.setImageResource(R.drawable.youwin)
            CountApp().setNumOfWins()
        }else if (countLose > countWin){
            binding.resultDrawFinal.setImageResource(R.drawable.youlose)
            CountApp().setNumOfLoses()
        }else{
            binding.resultDrawFinal.setImageResource(R.drawable.drawgame)
            CountApp().setNumOfDraws()
        }

        if (CountApp().getBattleFormat()==1){
            if (countDraw > (CountApp().getCount()/2)){
                binding.resultDrawFinal.setImageResource(R.drawable.drawgame)
                CountApp().setNumOfDraws()
            }
        }

        binding.finCountWin.text = getString(R.string.win_count,countWin)
        binding.finCountLose.text = getString(R.string.lose_count,countLose)
        binding.finCountDraw.text = getString(R.string.draw_count,countDraw)

        val intent = Intent(application,TitleActivity::class.java)
        binding.backTitle.setOnClickListener {
            CountApp().clearResult()
            startActivity(intent)
        }
    }
}