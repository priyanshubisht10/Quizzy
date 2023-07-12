package com.example.quizzy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizzy.MainActivity
import com.example.quizzy.R
import com.example.quizzy.utils.Constants

class resultActivity : AppCompatActivity() {

    private lateinit var finalscore: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        finalscore = findViewById(R.id.score)
        button = findViewById(R.id.home)



        val score = intent.getIntExtra(Constants.SCORE,0)
        finalscore.text = "${score}/10"

        button.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }





    }
}