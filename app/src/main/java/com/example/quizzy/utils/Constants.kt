package com.example.quizzy.utils

import com.example.quizzy.R
import com.example.quizzy.model.Question

object Constants{

    const val SCORE = "correct_answers"

    fun getQuestions(): MutableList<Question> {

        val questions = mutableListOf<Question>()




        val ques1 = Question(
            1,
            "Choose the country to which this flag belongs!",
            R.drawable.bharat,
            "Italy",
            "India",
            "Australia",
            "Sri lanka",
            2
        )

        val ques2 = Question(
            2,
            "Choose the country to which this flag belongs!",
            R.drawable.srilanka,
            "Bahrain",
            "Haiti",
            "Australia",
            "Sri lanka",
            4
        )

        val ques3 = Question(
            3,
            "Choose the country to which this flag belongs!",
            R.drawable.portugal2,
            "Italy",
            "India",
            "Portugal",
            "Spain",
            3
        )

        val ques4 = Question(
            4,
            "Choose the country to which this flag belongs!",
            R.drawable.usa,
            "England",
            "USA",
            "Australia",
            "Canada",
            2
        )

        val ques5 = Question(
            5,
            "Choose the country to which this flag belongs!",
            R.drawable.france,
            "Rome",
            "Germany",
            "France",
            "None of the above",
            3
        )

        val ques6 = Question(
            6,
            "Choose the country to which this flag belongs!",
            R.drawable.nigeria,
            "Italy",
            "Nigeria",
            "Niger",
            "South Africa",
            2
        )

        val ques7 = Question(
            7,
            "Choose the country to which this flag belongs!",
            R.drawable.canada,
            "Pakistan",
            "Brazil",
            "Austria",
            "Canada",
            4
        )

        val ques8 = Question(
            8,
            "Choose the country to which this flag belongs!",
            R.drawable.germany,
            "Italy",
            "Germany",
            "Australia",
            "Sri Lanka",
            2
        )

        val ques9 = Question(
            9,
            "Choose the country to which this flag belongs!",
            R.drawable.australia,
            "Germany",
            "India",
            "Australia",
            "Sri lanka",
            3
        )

        val ques10 = Question(
            10,
            "Choose the country to which this flag belongs!",
            R.drawable.argentina,
            "Argentina",
            "India",
            "Uruguay",
            "Haiti",
            1
        )

        questions.add(ques1)
        questions.add(ques2)
        questions.add(ques3)
        questions.add(ques4)
        questions.add(ques5)
        questions.add(ques6)
        questions.add(ques7)
        questions.add(ques8)
        questions.add(ques9)
        questions.add(ques10)

        return questions


    }


}