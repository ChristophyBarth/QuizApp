package capps.quiz.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultFragmentVM(score: Int, questionCount: Int) : ViewModel() {
    private val _resultTitle = MutableLiveData<String>()
    val resultTitle : LiveData<String> get() = _resultTitle

    private val _resultMessage = MutableLiveData<String>()
    val resultMessage : LiveData<String> get() = _resultMessage

    private val _scoreText = MutableLiveData<String>()
    val scoreText : LiveData<String> get() = _scoreText

    private val _earnedCoins = MutableLiveData<String>()
    val earnedCoins : LiveData<String> get() = _earnedCoins

    init {
        if (((score.toDouble()/questionCount.toDouble()) * 100).toInt() == 0){
            _resultTitle.value = "Oh No! You failed"
            _resultMessage.value = "Unfortunately, you got none of the questions correct."
        } else if (((score.toDouble()/questionCount.toDouble()) * 100).toInt() >= 50){
            _resultTitle.value = "Congratulations!"
            _resultMessage.value = "Well done! You did really amazing back there!"
        }else{
            _resultTitle.value = "You Tried"
            _resultMessage.value = "You did your best. However, you need to improvise."
        }

        _scoreText.value = "$score/$questionCount"
        _earnedCoins.value = "${score * 25}"
    }
}