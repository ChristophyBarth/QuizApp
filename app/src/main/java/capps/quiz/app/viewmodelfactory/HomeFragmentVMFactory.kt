package capps.quiz.app.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import capps.quiz.app.viewmodel.HomeFragmentVM

class HomeFragmentVMFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentVM::class.java)){
            return HomeFragmentVM() as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}