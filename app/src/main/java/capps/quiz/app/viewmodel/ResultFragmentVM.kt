package capps.quiz.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultFragmentVM(score: Int, questionCount: Int) : ViewModel() {
    val resultTitle = MutableLiveData<String>()
    val resultMessage = MutableLiveData<String>()

    val scoreText = MutableLiveData<String>()
    val earnedCoins = MutableLiveData<String>()

    init {
        if (((score.toDouble()/questionCount.toDouble()) * 100).toInt() == 0){
            resultTitle.value = "Oh No! You failed"
            resultMessage.value = "Unfortunately, you got none of the questions correct."
        } else if (((score.toDouble()/questionCount.toDouble()) * 100).toInt() >= 50){
            resultTitle.value = "Congratulations!"
            resultMessage.value = "Well done! You did really amazing back there!"
        }else{
            resultTitle.value = "You Tried"
            resultMessage.value = "You did your best. However, you need to improvise."
        }

        scoreText.value = "$score/$questionCount"
        earnedCoins.value = "${score * 25}"
    }
}