package com.example.jankenkamadakotlin2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.jankenkamadakotlin2.databinding.ActivitySelectBinding


class SelectActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySelectBinding
    @SuppressLint("SetTextI18n", "SourceLockedOrientationActivity", "RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        binding.modeChange.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1 == 1){
                    binding.gameMode.text = "星取り　戦"
                    binding.rule.text =
                            "1.対戦形式は任意で1～10まで対戦できます\n" +
                            "2.設定した回戦数の半分以上を満たした\n" +
                            "場合終了します\n" +
                            "3.設定した回数を達した場合終了します\n"+
                            "4.設定した回数が半分以上があいこだった\n" +
                            "場合は引き分けとします"
                    CountApp().setBattleFormat(1)
                }else{
                    binding.gameMode.text = "総当たり戦"
                    binding.rule.text =
                            "1.対戦形式は任意で1～10まで対戦できます\n" +
                            "2.対戦は勝敗に問わずカウントします\n" +
                            "3.設定した値まで終了しません\n" +
                            "4.結果は総合的に判断します\n\n\n"
                    CountApp().setBattleFormat(0)
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        binding.gameCount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.roundCount.text = "回数："+(p1+1)
                CountApp().setCount(p1+1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        val intent = Intent(application,MainActivity::class.java)

        binding.gameStart.setOnClickListener {
            startActivity(intent)
        }
    }
}