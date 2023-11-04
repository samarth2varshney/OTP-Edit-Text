package com.example.otp_edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.otp_edit_text.OtpEditText
import com.example.otp_edittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.otp.getText()


    }
}