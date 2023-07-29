package capps.quiz.app.model

class Option {
    var a : String? = null
    var b : String? = null
    var c : String? = null
    var d : String? = null

    constructor()

    constructor(a: String?, b: String?, c: String?, d: String?) {
        this.a = a
        this.b = b
        this.c = c
        this.d = d
    }
}