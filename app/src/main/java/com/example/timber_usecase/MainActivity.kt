package com.example.timber_usecase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timber_usecase.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG_LOGGING_ENABLED) {
            Timber.plant(MyTimberTree())
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.d("Debug log")
        Timber.i("Information log")
        Timber.v("Verbose log")
        Timber.w("Warning log")
        Timber.e("Error log")
        Timber.wtf("What a Terrible Failure log")

        Timber.tag("customTag").d("custom tag Log")

        binding.btnGoSecondActivity.setOnClickListener {
            goSecondActivityFunction()
        }
    }

    private fun goSecondActivityFunction() {
        val activityName = "SecondActivity"
        Timber.d("Go $activityName!")
        Timber.d("Start %s!", activityName)

        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}