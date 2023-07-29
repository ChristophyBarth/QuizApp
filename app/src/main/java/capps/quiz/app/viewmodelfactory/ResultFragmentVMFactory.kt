package capps.quiz.app.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import capps.quiz.app.viewmodel.ResultFragmentVM
import java.lang.IllegalArgumentException

class ResultFragmentVMFactory(private val score: Int, private val questionCount: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultFragmentVM::class.java)){
            return ResultFragmentVM(score, questionCount) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}