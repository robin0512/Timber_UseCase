package com.example.timber_usecase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timber_usecase.databinding.ActivitySecondBinding
import timber.log.Timber

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.d("SecondActivity here!")
    }
}