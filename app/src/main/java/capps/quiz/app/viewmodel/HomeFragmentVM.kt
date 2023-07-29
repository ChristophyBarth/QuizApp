package capps.quiz.app.viewmodel

import androidx.lifecycle.ViewModel
import capps.quiz.app.R
import capps.quiz.app.others.SingleLiveEvent
import capps.quiz.app.others.UiText

class HomeFragmentVM : ViewModel() {
    val uiText = SingleLiveEvent<UiText.StringResource>()

    fun type1(){
        uiText.value = UiText.StringResource(R.string.mathematics)
    }
    fun type2(){
        uiText.value = UiText.StringResource(R.string.science)
    }
    fun type3(){
        uiText.value = UiText.StringResource(R.string.drama)
    }
    fun type4(){
        uiText.value = UiText.StringResource(R.string.art_and_craft)
    }
    fun type5(){
        uiText.value = UiText.StringResource(R.string.knowledge)
    }
    fun type6(){
        uiText.value = UiText.StringResource(R.string.language)
    }
}