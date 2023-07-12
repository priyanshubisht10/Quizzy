package com.example.quizzy.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizzy.utils.Constants

import com.example.quizzy.R
import com.example.quizzy.model.Question

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var progresstext: TextView
    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView

    private var currentposition = 1


    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false

    private lateinit var question: Question

    private var score = 0

    private lateinit var flagimg: ImageView
    private lateinit var button: Button
    private lateinit var questionList: MutableList<Question>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionList = Constants.getQuestions()
        Log.d("Question Size: ", "${questionList.size}")


        progresstext = findViewById(R.id.change_progress)
        progressBar = findViewById(R.id.progressBar)

        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        flagimg = findViewById(R.id.flag_image)

        button = findViewById(R.id.button_check)


        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        button.setOnClickListener(this)


        setQuestion()

    }


    private fun setQuestion() {

        if (currentposition > questionList.size) {
            button.text = "FINISH"
            Intent(this, resultActivity::class.java).also {
                it.putExtra(Constants.SCORE, score)
                startActivity(it)
            }
        } else {

            button.text = "CHECK"
            currentQuestion = questionList[currentposition - 1]

            resetOptions()

            question = questionList[currentposition - 1]

            flagimg.setImageResource(question.image)

            option1.text = question.opt1
            option2.text = question.opt2
            option3.text = question.opt3
            option4.text = question.opt4

            progressBar.setProgress(currentposition)
            progresstext.text = "${currentposition}/10"

        }

        currentposition = currentposition + 1
        answered = false

    }


    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(option1)
        options.add(option2)
        options.add(option3)
        options.add(option4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_bg
            )
        }
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option1 -> {
                selectedOption(option1, 1)
            }

            R.id.option2 -> {
                selectedOption(option2, 2)
            }

            R.id.option3 -> {
                selectedOption(option3, 3)
            }

            R.id.option4 -> {
                selectedOption(option4, 4)
            }


            R.id.button_check -> {

                if (answered) {
                    setQuestion()
                } else {
                    checkAnswer()
                }
                selectedAnswer = 0

            }
        }
    }


    private fun selectedOption(textView: TextView, selectOptionNumber: Int) {
        resetOptions()
        selectedAnswer = selectOptionNumber

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)


    }


    private fun checkAnswer() {

        answered = true

        if (selectedAnswer == currentQuestion.correctanswer) {
            score++
            when (selectedAnswer) {
                1 -> {
                    option1.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }

                2 -> {
                    option2.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }

                3 -> {
                    option3.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }

                4 -> {
                    option4.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }
            }
        } else {

            when (currentQuestion.correctanswer) {
                1 -> {
                    option1.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }

                2 -> {
                    option2.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }

                3 -> {
                    option3.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }

                4 -> {
                    option4.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.selected_option_border_bg
                        )
                }
            }


            when (selectedAnswer) {
                1 -> {
                    option1.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }

                2 -> {
                    option2.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }

                3 -> {
                    option3.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }

                4 -> {
                    option4.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }
            }

        }

        button.text = "NEXT"
    }


}