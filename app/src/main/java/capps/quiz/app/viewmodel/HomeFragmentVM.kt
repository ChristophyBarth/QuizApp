package capps.quiz.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import capps.quiz.app.R
import capps.quiz.app.others.SingleLiveEvent
import capps.quiz.app.others.UiText

class HomeFragmentVM : ViewModel() {
    private val _uiText = SingleLiveEvent<UiText.StringResource>()
    val uiText : LiveData<UiText.StringResource> get() = _uiText

    fun type1(){
        _uiText.value = UiText.StringResource(R.string.mathematics)
    }
    fun type2(){
        _uiText.value = UiText.StringResource(R.string.science)
    }
    fun type3(){
        _uiText.value = UiText.StringResource(R.string.drama)
    }
    fun type4(){
        _uiText.value = UiText.StringResource(R.string.art_and_craft)
    }
    fun type5(){
        _uiText.value = UiText.StringResource(R.string.knowledge)
    }
    fun type6(){
        _uiText.value = UiText.StringResource(R.string.language)
    }
}