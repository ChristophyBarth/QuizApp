package capps.quiz.app.model

class Quiz {
    var question: String? = null
    var options: Option? = null
    var answer: String? = null

    constructor()

    constructor(question: String?, options: Option?, answer: String) {
        this.question = question
        this.options = options
        this.answer = answer
    }
}