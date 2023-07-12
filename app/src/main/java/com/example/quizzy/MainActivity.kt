package com.example.quizzy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizzy.ui.QuestionsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbutton: Button = findViewById(R.id.startbutton)
        val edittextname: EditText = findViewById(R.id.name)
        edittextname.setTextColor(Color.BLACK)

        startbutton.setOnClickListener {

            if (!edittextname.text.isEmpty()) {
                Intent(
                    this@MainActivity,
                    QuestionsActivity::class.java
                ).also {
                    startActivity(it)
                    finish()
                }
            } else {
                edittextname.hint = "Enter name!"
                edittextname.setHintTextColor(Color.RED)

                Toast.makeText(
                    this@MainActivity,
                    "cannot start quiz without name",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}