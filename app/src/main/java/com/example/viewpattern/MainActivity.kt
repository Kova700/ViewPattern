package com.example.viewpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewpattern.data.Book
import com.example.viewpattern.databinding.ActivityMainBinding
import com.example.viewpattern.databinding.ActivityMvcactivityBinding
import com.example.viewpattern.utils.Constansts.TAG

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "MainActivity: onCreate() - called")
        setContentView(binding.root)

        binding.goMVCBtn.setOnClickListener {
            val intent = Intent(this,MVCActivity::class.java)
            startActivity(intent)
        }

        binding.goMVVMBtn.setOnClickListener {
            val intent = Intent(this,MVVMActivity::class.java)
            startActivity(intent)
        }
    }


}