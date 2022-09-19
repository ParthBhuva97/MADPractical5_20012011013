package com.example.madpractical5_20012011013

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madpractical5_20012011013.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0
        binding.playButton.setOnClickListener {
            count++
            play()
            if(count%2!=0){
                binding.playButton.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_pause_24))
            }
            else{
                binding.playButton.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_play_arrow_24))
            }
        }

        binding.stopButton.setOnClickListener {
            stop()
        }
    }

    private fun play(){
        Intent(applicationContext,MediaService::class.java).putExtra(MediaService.DATA_KEY,MediaService.DATA_VALUE).apply {
            startService(this)
        }
    }

    private fun stop(){
        Intent(applicationContext,MediaService::class.java).apply{
            stopService(this)
        }
    }

}