package capps.quiz.app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import capps.quiz.app.R
import capps.quiz.app.others.SingleLiveEvent
import capps.quiz.app.model.Quiz

class QuizFragmentVM(quizTopic: String, questionList: MutableList<Quiz>): ViewModel() {
    private val _topic = MutableLiveData<String>()
    val topic : LiveData<String> get() = _topic

    private val _questions = MutableLiveData<MutableList<Quiz>>()
    val questions : LiveData<MutableList<Quiz>> get() =  _questions

    private val _buttonText = MutableLiveData<String>()
    val buttonText : LiveData<String> get() = _buttonText

    private val _currentQuestionForTv = MutableLiveData<String>()
    val currentQuestionForTv : LiveData<String> get() = _currentQuestionForTv

    private val _scroll = MutableLiveData<Boolean>()
    val scroll : LiveData<Boolean> get() = _scroll

    private val _questionCount = MutableLiveData<String>()
    val questionCount : LiveData<String> get() = _questionCount

    private val _userSelection = MutableLiveData<String>()
    val userSelection : LiveData<String> get() = _userSelection

    private val _buttonClicked = SingleLiveEvent<Boolean>()
    val buttonClicked : LiveData<Boolean> get() = _buttonClicked

    private val _currentQuestion = MutableLiveData<Int>()
    val currentQuestion : LiveData<Int> get() = _currentQuestion

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> get() = _score

    private val _option1Selection = MutableLiveData<Int>()
    val option1Selection : LiveData<Int> get() = _option1Selection

    private val _option2Selection = MutableLiveData<Int>()
    val option2Selection : LiveData<Int> get() = _option2Selection

    private val _option3Selection = MutableLiveData<Int>()
    val option3Selection : LiveData<Int> get() = _option3Selection

    private val _option4Selection = MutableLiveData<Int>()
    val option4Selection : LiveData<Int> get() = _option4Selection

    private val _radio1Selected = MutableLiveData<Boolean>()
    val radio1Selected : LiveData<Boolean> get() = _radio1Selected

    private val _radio2Selected = MutableLiveData<Boolean>()
    val radio2Selected : LiveData<Boolean> get() = _radio2Selected

    private val _radio3Selected = MutableLiveData<Boolean>()
    val radio3Selected : LiveData<Boolean> get() = _radio3Selected

    private val _radio4Selected = MutableLiveData<Boolean>()
    val radio4Selected : LiveData<Boolean> get() = _radio4Selected

    private val _option1TextColor = MutableLiveData<Int>()
    val option1TextColor : LiveData<Int> get() = _option1TextColor

    private val _option2TextColor = MutableLiveData<Int>()
    val option2TextColor : LiveData<Int> get() = _option2TextColor

    private val _option3TextColor = MutableLiveData<Int>()
    val option3TextColor : LiveData<Int> get() = _option3TextColor

    private val _option4TextColor = MutableLiveData<Int>()
    val option4TextColor : LiveData<Int> get() = _option4TextColor

    private val _question = MutableLiveData<String>()
    val question : LiveData<String> = _question

    private val _option1 = MutableLiveData<String>()
    val option1 : LiveData<String> get() = _option1

    private val _option2 = MutableLiveData<String>()
    val option2 : LiveData<String> get() = _option2

    private val _option3 = MutableLiveData<String>()
    val option3 : LiveData<String> get() = _option3

    private val _option4 = MutableLiveData<String>()
    val option4 : LiveData<String> get() = _option4

    val buttonTextChanger = MediatorLiveData<String>().also {
        it.addSource(radio1Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                _buttonText.value = "Submit"
            }
        }
        it.addSource(radio2Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                _buttonText.value = "Submit"
            }
        }
        it.addSource(radio3Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                _buttonText.value = "Submit"
            }
        }
        it.addSource(radio4Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                _buttonText.value = "Submit"
            }
        }
    }

    init {
        _topic.value = "$quizTopic Quiz"
        _buttonText.value = "Next"
        _userSelection.value = ""

        _option1Selection.value = R.drawable.not_answer_bg
        _option2Selection.value = R.drawable.not_answer_bg
        _option3Selection.value = R.drawable.not_answer_bg
        _option4Selection.value = R.drawable.not_answer_bg

        _option1TextColor.value = R.color.white
        _option2TextColor.value = R.color.white
        _option3TextColor.value = R.color.white
        _option4TextColor.value = R.color.white

        _radio1Selected.value = false
        _radio2Selected.value = false
        _radio3Selected.value = false
        _radio4Selected.value = false

        _questions.value = questionList
        _questionCount.value = "/${questions.value!!.size}"

        _currentQuestion.value = 0
        _currentQuestionForTv.value = _currentQuestion.value!!.plus(1).toString()
        _score.value = 0

        setQuestion(questions.value!![_currentQuestion.value!!])
    }

    private fun setQuestion(quiz: Quiz) {
        _question.value = quiz.question
        _option1.value = quiz.options!!.a
        _option2.value = quiz.options!!.b
        _option3.value = quiz.options!!.c
        _option4.value = quiz.options!!.d
        quiz.selected = true
    }

    fun next(){
        if (_userSelection.value != "") {
            if (_userSelection.value == questions.value!![_currentQuestion.value!!].answer) {
                _score.value = _score.value!!.plus(1)
            }

            if (_currentQuestion.value!! + 1 < questions.value!!.size) {
                _userSelection.value = ""

                _option1Selection.value = R.drawable.not_answer_bg
                _option2Selection.value = R.drawable.not_answer_bg
                _option3Selection.value = R.drawable.not_answer_bg
                _option4Selection.value = R.drawable.not_answer_bg

                _option1TextColor.value = R.color.white
                _option2TextColor.value = R.color.white
                _option3TextColor.value = R.color.white
                _option4TextColor.value = R.color.white

                _radio1Selected.value = false
                _radio2Selected.value = false
                _radio3Selected.value = false
                _radio4Selected.value = false

                _currentQuestion.value = _currentQuestion.value!! + 1
                _currentQuestionForTv.value = _currentQuestion.value!!.plus(1).toString()
                setQuestion(questions.value!![_currentQuestion.value!!])

                _scroll.value = true
            } else {
                Log.d("QuizVM", "Questions Finished")
            }

        }

        _buttonClicked.value = true
    }

    fun option1Button(){
        _userSelection.value = questions.value!![_currentQuestion.value!!].options!!.a

        _option1TextColor.value = R.color.my_green
        _option2TextColor.value = R.color.white
        _option3TextColor.value = R.color.white
        _option4TextColor.value = R.color.white

        _option1Selection.value = R.drawable.answer_bg
        _option2Selection.value = R.drawable.not_answer_bg
        _option3Selection.value = R.drawable.not_answer_bg
        _option4Selection.value = R.drawable.not_answer_bg

        _radio1Selected.value = true
        _radio2Selected.value = false
        _radio3Selected.value = false
        _radio4Selected.value = false
    }

    fun option2Button(){
        _userSelection.value = questions.value!![_currentQuestion.value!!].options!!.b

        _option1TextColor.value = R.color.white
        _option2TextColor.value = R.color.my_green
        _option3TextColor.value = R.color.white
        _option4TextColor.value = R.color.white

        _option1Selection.value = R.drawable.not_answer_bg
        _option2Selection.value = R.drawable.answer_bg
        _option3Selection.value = R.drawable.not_answer_bg
        _option4Selection.value = R.drawable.not_answer_bg

        _radio1Selected.value = false
        _radio2Selected.value = true
        _radio3Selected.value = false
        _radio4Selected.value = false
    }

    fun option3Button(){
        _userSelection.value = questions.value!![_currentQuestion.value!!].options!!.c

        _option1TextColor.value = R.color.white
        _option2TextColor.value = R.color.white
        _option3TextColor.value = R.color.my_green
        _option4TextColor.value = R.color.white

        _option1Selection.value = R.drawable.not_answer_bg
        _option2Selection.value = R.drawable.not_answer_bg
        _option3Selection.value = R.drawable.answer_bg
        _option4Selection.value = R.drawable.not_answer_bg

        _radio1Selected.value = false
        _radio2Selected.value = false
        _radio3Selected.value = true
        _radio4Selected.value = false
    }

    fun option4Button(){
        _userSelection.value = questions.value!![_currentQuestion.value!!].options!!.d

        _option1TextColor.value = R.color.white
        _option2TextColor.value = R.color.white
        _option3TextColor.value = R.color.white
        _option4TextColor.value = R.color.my_green

        _option1Selection.value = R.drawable.not_answer_bg
        _option2Selection.value = R.drawable.not_answer_bg
        _option3Selection.value = R.drawable.not_answer_bg
        _option4Selection.value = R.drawable.answer_bg

        _radio1Selected.value = false
        _radio2Selected.value = false
        _radio3Selected.value = false
        _radio4Selected.value = true
    }
}