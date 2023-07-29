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
    var topic = MutableLiveData<String>()

    private var questions = mutableListOf<Quiz>()
    var questionCount = MutableLiveData<String>()

    private val _userSelection = MutableLiveData<String>()
    val userSelection : MutableLiveData<String> get() = _userSelection

    val buttonText = MutableLiveData<String>()
    val buttonClicked = SingleLiveEvent<Boolean>()

    val indicator1 = MutableLiveData<Int>()
    val indicator2 = MutableLiveData<Int>()
    val indicator3 = MutableLiveData<Int>()

    val option1Selection = MutableLiveData<Int>()
    val option2Selection = MutableLiveData<Int>()
    val option3Selection = MutableLiveData<Int>()
    val option4Selection = MutableLiveData<Int>()

    val radio1Selected = MutableLiveData<Boolean>()
    val radio2Selected = MutableLiveData<Boolean>()
    val radio3Selected = MutableLiveData<Boolean>()
    val radio4Selected = MutableLiveData<Boolean>()

    val option1TextColor = MutableLiveData<Int>()
    val option2TextColor = MutableLiveData<Int>()
    val option3TextColor = MutableLiveData<Int>()
    val option4TextColor = MutableLiveData<Int>()

    private val _currentQuestion = MutableLiveData<Int>()
    val currentQuestion : LiveData<Int> get() = _currentQuestion
    val currentQuestionForTv = MutableLiveData<String>()

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    val question = MutableLiveData<String>()
    val option1 = MutableLiveData<String>()
    val option2 = MutableLiveData<String>()
    val option3 = MutableLiveData<String>()
    val option4 = MutableLiveData<String>()

    val buttonTextChanger = MediatorLiveData<String>().also {
        it.addSource(radio1Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                buttonText.value = "Submit"
            }
        }
        it.addSource(radio2Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                buttonText.value = "Submit"
            }
        }
        it.addSource(radio3Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                buttonText.value = "Submit"
            }
        }
        it.addSource(radio4Selected){
            if (_currentQuestion.value!!.plus(1) == 3 && _userSelection.value != ""){
                buttonText.value = "Submit"
            }
        }
    }

    init {
        topic.value = "$quizTopic Quiz"
        buttonText.value = "Next"
        _userSelection.value = ""

        indicator1.value = R.drawable.indicator_bg
        indicator2.value = R.drawable.indicator2_bg
        indicator3.value = R.drawable.indicator2_bg

        option1Selection.value = R.drawable.not_answer_bg
        option2Selection.value = R.drawable.not_answer_bg
        option3Selection.value = R.drawable.not_answer_bg
        option4Selection.value = R.drawable.not_answer_bg

        option1TextColor.value = R.color.white
        option2TextColor.value = R.color.white
        option3TextColor.value = R.color.white
        option4TextColor.value = R.color.white

        radio1Selected.value = false
        radio2Selected.value = false
        radio3Selected.value = false
        radio4Selected.value = false

        questions = questionList
        questionCount.value = "/${questions.size}"

        _currentQuestion.value = 0
        currentQuestionForTv.value = _currentQuestion.value!!.plus(1).toString()
        _score.value = 0

        setQuestion(questions[_currentQuestion.value!!])
    }

    private fun setQuestion(quiz: Quiz) {
        question.value = quiz.question
        option1.value = quiz.options!!.a
        option2.value = quiz.options!!.b
        option3.value = quiz.options!!.c
        option4.value = quiz.options!!.d
    }

    fun next(){
        if (_userSelection.value != "") {
            if (_userSelection.value == questions[_currentQuestion.value!!].answer) {
                _score.value = _score.value!!.plus(1)
            }

            if (_currentQuestion.value!! + 1 < questions.size) {
                _userSelection.value = ""

                option1Selection.value = R.drawable.not_answer_bg
                option2Selection.value = R.drawable.not_answer_bg
                option3Selection.value = R.drawable.not_answer_bg
                option4Selection.value = R.drawable.not_answer_bg

                option1TextColor.value = R.color.white
                option2TextColor.value = R.color.white
                option3TextColor.value = R.color.white
                option4TextColor.value = R.color.white

                radio1Selected.value = false
                radio2Selected.value = false
                radio3Selected.value = false
                radio4Selected.value = false

                _currentQuestion.value = _currentQuestion.value!! + 1
                currentQuestionForTv.value = _currentQuestion.value!!.plus(1).toString()
                setQuestion(questions[_currentQuestion.value!!])
            } else {
                Log.d("QuizVM", "Questions Finished")
            }

            when (_currentQuestion.value) {
                0 -> {
                    indicator1.value = R.drawable.indicator_bg
                    indicator2.value = R.drawable.indicator2_bg
                    indicator3.value = R.drawable.indicator2_bg
                }

                1 -> {
                    indicator1.value = R.drawable.indicator_bg
                    indicator2.value = R.drawable.indicator_bg
                    indicator3.value = R.drawable.indicator2_bg
                }

                2 -> {
                    indicator1.value = R.drawable.indicator_bg
                    indicator2.value = R.drawable.indicator_bg
                    indicator3.value = R.drawable.indicator_bg
                }
            }
        }

        buttonClicked.value = true
    }

    fun option1(){
        _userSelection.value = questions[_currentQuestion.value!!].options!!.a

        option1TextColor.value = R.color.my_green
        option2TextColor.value = R.color.white
        option3TextColor.value = R.color.white
        option4TextColor.value = R.color.white

        option1Selection.value = R.drawable.answer_bg
        option2Selection.value = R.drawable.not_answer_bg
        option3Selection.value = R.drawable.not_answer_bg
        option4Selection.value = R.drawable.not_answer_bg

        radio1Selected.value = true
        radio2Selected.value = false
        radio3Selected.value = false
        radio4Selected.value = false
    }

    fun option2(){
        _userSelection.value = questions[_currentQuestion.value!!].options!!.b

        option1TextColor.value = R.color.white
        option2TextColor.value = R.color.my_green
        option3TextColor.value = R.color.white
        option4TextColor.value = R.color.white

        option1Selection.value = R.drawable.not_answer_bg
        option2Selection.value = R.drawable.answer_bg
        option3Selection.value = R.drawable.not_answer_bg
        option4Selection.value = R.drawable.not_answer_bg

        radio1Selected.value = false
        radio2Selected.value = true
        radio3Selected.value = false
        radio4Selected.value = false
    }

    fun option3(){
        _userSelection.value = questions[_currentQuestion.value!!].options!!.c

        option1TextColor.value = R.color.white
        option2TextColor.value = R.color.white
        option3TextColor.value = R.color.my_green
        option4TextColor.value = R.color.white

        option1Selection.value = R.drawable.not_answer_bg
        option2Selection.value = R.drawable.not_answer_bg
        option3Selection.value = R.drawable.answer_bg
        option4Selection.value = R.drawable.not_answer_bg

        radio1Selected.value = false
        radio2Selected.value = false
        radio3Selected.value = true
        radio4Selected.value = false
    }

    fun option4(){
        _userSelection.value = questions[_currentQuestion.value!!].options!!.d

        option1TextColor.value = R.color.white
        option2TextColor.value = R.color.white
        option3TextColor.value = R.color.white
        option4TextColor.value = R.color.my_green

        option1Selection.value = R.drawable.not_answer_bg
        option2Selection.value = R.drawable.not_answer_bg
        option3Selection.value = R.drawable.not_answer_bg
        option4Selection.value = R.drawable.answer_bg

        radio1Selected.value = false
        radio2Selected.value = false
        radio3Selected.value = false
        radio4Selected.value = true
    }
}