package capps.quiz.app.others

import android.content.Context
import capps.quiz.app.R
import capps.quiz.app.model.Option
import capps.quiz.app.model.Quiz

class Quizzes(private val context: Context, private val topic: String) {
    fun getQuestions(): MutableList<Quiz> {
        when (topic) {
            context.getString(R.string.mathematics) -> {
                val myQuestions = mutableListOf<Quiz>()

                val options1 = Option("10", "14", "12", "24")
                myQuestions.add(Quiz("Simplify the expression: 2(3 + 5) - 4", options1, options1.c!!))

                val options2 = Option("x = 8", "x = 3", "x = 1", "x = 16")
                myQuestions.add(Quiz("Solve the equation: 2x - 7 = 9", options2, options2.a!!))

                val option3 = Option("Equilateral triangle", "Isosceles triangle", "Scalene triangle", "Right triangle")
                myQuestions.add(Quiz("If a triangle has angles measuring 30°, 60°, and 90°, what type of triangle is it?", option3, option3.d!!))

                return myQuestions
            }

            else -> {
                val myQuestions = mutableListOf<Quiz>()

                val options1 = Option("10", "14", "12", "24")
                myQuestions.add(Quiz("Simplify the expression: 2(3 + 5) - 4", options1, options1.c!!))

                val options2 = Option("x = 8", "x = 3", "x = 1", "x = 16")
                myQuestions.add(Quiz("Solve the equation: 2x - 7 = 9", options2, options2.a!!))

                val option3 = Option("Equilateral triangle", "Isosceles triangle", "Scalene triangle", "Right triangle")
                myQuestions.add(Quiz("If a triangle has angles measuring 30°, 60°, and 90°, what type of triangle is it?", option3, option3.d!!))

                return myQuestions
            }
        }
    }
}