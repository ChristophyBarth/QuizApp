package capps.quiz.app.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import capps.quiz.app.model.Quiz
import capps.quiz.app.viewmodel.QuizFragmentVM

class QuizFragmentVMFactory(private val quizTopic: String, private val questionList: MutableList<Quiz>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizFragmentVM::class.java)){
            return QuizFragmentVM(quizTopic, questionList) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}