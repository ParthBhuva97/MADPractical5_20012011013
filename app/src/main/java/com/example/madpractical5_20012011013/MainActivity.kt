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

        binding.playButton.setOnClickListener {
            play()
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