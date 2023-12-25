package com.example.suitmediatest.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmediatest.databinding.ActivityFirstScreenBinding

class FirstScreen : AppCompatActivity() {
    private lateinit var binding: ActivityFirstScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.check.setOnClickListener{
            buttonCheckPalindrome()
        }

        binding.next.setOnClickListener {
            val intent = Intent(this@FirstScreen, SecondScreen::class.java)
            startActivity(intent)
        }
    }

    private fun buttonCheckPalindrome() {
        val charInput = binding.palindrome.text.toString().toCharArray()
        val intLength = charInput.size
        var isPalindrome = true

        for (i in 0 until intLength / 2) {
            if (charInput[i] != charInput[intLength - 1 - i]) {
                isPalindrome = false
                break
            }
        }
        if (isPalindrome) {
            Toast.makeText(this@FirstScreen, "is Palindrome", Toast.LENGTH_LONG)
                .show()
        } else {
            Toast.makeText(this@FirstScreen, "not Palindrome", Toast.LENGTH_LONG)
                .show()
        }
    }
}