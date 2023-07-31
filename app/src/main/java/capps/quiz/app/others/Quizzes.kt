package capps.quiz.app.others

import android.content.Context
import capps.quiz.app.R
import capps.quiz.app.model.Option
import capps.quiz.app.model.Quiz

class Quizzes(private val context: Context, private val topic: String) {
    fun getQuestions(): MutableList<Quiz> {
        when (topic) {
            context.getString(R.string.mathematics) -> {
                val mathematicsQuestions = mutableListOf<Quiz>()

                val options1 = Option("10", "14", "12", "24")
                mathematicsQuestions.add(
                    Quiz(
                        "Simplify the expression: 2(3 + 5) - 4",
                        options1,
                        options1.c!!
                    )
                )

                val options2 = Option("x = 8", "x = 3", "x = 1", "x = 16")
                mathematicsQuestions.add(
                    Quiz(
                        "Solve the equation: 2x - 7 = 9",
                        options2,
                        options2.a!!
                    )
                )

                val option3 = Option(
                    "Equilateral triangle",
                    "Isosceles triangle",
                    "Scalene triangle",
                    "Right triangle"
                )
                mathematicsQuestions.add(
                    Quiz(
                        "If a triangle has angles measuring 30°, 60°, and 90°, what type of triangle is it?",
                        option3,
                        option3.d!!
                    )
                )

                /*val options4 = Option("4", "6", "9", "12")
                mathematicsQuestions.add(
                    Quiz(
                        "What is the square root of 36?",
                        options4,
                        options4.b!!
                    )
                )

                val options5 = Option("16 sq units", "32 sq units", "64 sq units", "72 sq units")
                mathematicsQuestions.add(
                    Quiz(
                        "What is the area of a square with side length 8 units?",
                        options5,
                        options5.c!!
                    )
                )

                val options6 = Option("20 units", "25 units", "30 units", "40 units")
                mathematicsQuestions.add(
                    Quiz(
                        "Find the perimeter of a rectangle with length 10 units and width 5 units.",
                        options6,
                        options6.d!!
                    )
                )

                val options7 = Option("10", "15", "8", "20")
                mathematicsQuestions.add(
                    Quiz(
                        "Calculate the sum of the first 5 natural numbers.",
                        options7,
                        options7.a!!
                    )
                )

                val options8 = Option("91", "55", "15", "27")
                mathematicsQuestions.add(
                    Quiz(
                        "Find the value of 3 squared plus 4 cubed.",
                        options8,
                        options8.a!!
                    )
                )

                val options9 = Option("6", "4", "8", "3")
                mathematicsQuestions.add(
                    Quiz(
                        "Solve the expression: 2 * (5 + 3) / 4",
                        options9,
                        options9.c!!
                    )
                )

                val options10 = Option("$6", "$20", "$24", "$30")
                mathematicsQuestions.add(
                    Quiz(
                        "A store is having a sale where all items are 20% off. If a shirt originally costs \$30, what is the sale price?",
                        options10,
                        options10.c!!
                    )
                )*/

                mathematicsQuestions.shuffle()
                return mathematicsQuestions
            }

/*            context.getString(R.string.science) -> {
                val scienceQuestions = mutableListOf<Quiz>()

                val option1 = Option("Atom", "Molecule", "Cell", "Electron")
                scienceQuestions.add(
                    Quiz(
                        "What is the smallest unit of matter?",
                        option1,
                        option1.a!!
                    )
                )

                val option2 = Option("Inertia", "Friction", "Gravity", "Magnetism")
                scienceQuestions.add(
                    Quiz(
                        "What is the force that pulls objects towards the center of the Earth?",
                        option2,
                        option2.c!!
                    )
                )

                val option3 = Option("Oxygen", "Nitrogen", "Carbon dioxide", "Argon")
                scienceQuestions.add(
                    Quiz(
                        "Which gas makes up the majority of the Earth's atmosphere?",
                        option3,
                        option3.b!!
                    )
                )

                val option4 = Option("Photosynthesis", "Respiration", "Fermentation", "Combustion")
                scienceQuestions.add(
                    Quiz(
                        "What is the process by which plants convert sunlight into energy?",
                        option4,
                        option4.a!!
                    )
                )

                val option5 = Option("Liver", "Kidney", "Pancreas", "Heart")
                scienceQuestions.add(
                    Quiz(
                        "Which organ in the human body is responsible for filtering waste from the blood?",
                        option5,
                        option5.b!!
                    )
                )

                val option6 = Option("Mercury", "Venus", "Earth", "Jupiter")
                scienceQuestions.add(
                    Quiz(
                        "What is the largest planet in our solar system?",
                        option6,
                        option6.d!!
                    )
                )

                val option7 = Option(
                    "Moon's gravitational pull",
                    "Earth's rotation",
                    "Sun's gravitational pull",
                    "Earth's magnetic field"
                )
                scienceQuestions.add(
                    Quiz(
                        "What causes the tides in the Earth's oceans?",
                        option7,
                        option7.a!!
                    )
                )

                scienceQuestions.shuffle()
                return scienceQuestions
            }

            context.getString(R.string.drama) -> {
                val dramaQuestions = mutableListOf<Quiz>()

                val options1 = Option("Mime", "Improvisation", "Pantomime", "Physical theatre")
                dramaQuestions.add(
                    Quiz(
                        "What is the term for the theatrical technique where actors mime their actions without using words?",
                        options1,
                        options1.c!!
                    )
                )

                val options2 = Option(
                    "A protagonist who meets a tragic fate due to a character flaw",
                    "A villain who brings about the downfall of the protagonist",
                    "A supporting character who provides comic relief",
                    "A character who undergoes a positive transformation"
                )
                dramaQuestions.add(Quiz("What is a tragic hero?", options2, options2.a!!))

                val options3 = Option(
                    "William Shakespeare",
                    "Oscar Wilde",
                    "Tennessee Williams",
                    "Samuel Beckett"
                )
                dramaQuestions.add(
                    Quiz(
                        "Who wrote the play \"Romeo and Juliet\"?",
                        options3,
                        options3.a!!
                    )
                )

                val options4 =
                    Option("Arthur Miller", "William Shakespeare", "Anton Chekhov", "Henrik Ibsen")
                dramaQuestions.add(
                    Quiz(
                        "Who is considered the father of modern drama?",
                        options4,
                        options4.d!!
                    )
                )

                val options5 = Option("Plot", "Theme", "Setting", "Dialogue")
                dramaQuestions.add(
                    Quiz(
                        "What is the term used to describe the structure of a dramatic work?",
                        options5,
                        options5.a!!
                    )
                )

                dramaQuestions.shuffle()
                return dramaQuestions
            }

            context.getString(R.string.art_and_craft) -> {
                val artAndCraftQuestions = mutableListOf<Quiz>()

                val options1 = Option("Embroidery", "Sculpting", "Decoupage", "Embossing")
                artAndCraftQuestions.add(
                    Quiz(
                        "What is the technique of creating raised designs on a surface called?",
                        options1,
                        options1.d!!
                    )
                )

                val options2 = Option("Pottery", "Collage", "Origami", "Mosaic")
                artAndCraftQuestions.add(
                    Quiz(
                        "Which art form involves shaping and attaching clay pieces together to create a sculpture?",
                        options2,
                        options2.a!!
                    )
                )

                val options3 = Option("Tie-dyeing", "Batik", "Quilling", "Stenciling")
                artAndCraftQuestions.add(
                    Quiz(
                        "What is the process of using melted wax to create designs on fabric or paper called?",
                        options3,
                        options3.b!!
                    )
                )

                val options4 = Option("Impressionism", "Pointillism", "Stippling", "Watercoloring")
                artAndCraftQuestions.add(
                    Quiz(
                        "Which art technique involves applying paint to a surface using small dots or strokes to create images?",
                        options4,
                        options4.b!!
                    )
                )

                val options5 = Option("Collage", "Decoupage", "Papercraft", "Origami")
                artAndCraftQuestions.add(
                    Quiz(
                        "What is the technique of cutting or tearing and arranging paper to create a design called?",
                        options5,
                        options5.a!!
                    )
                )

                val options6 = Option("Pottery", "Jewelry making", "Metalworking", "Glassblowing")
                artAndCraftQuestions.add(
                    Quiz(
                        "Which type of art involves shaping and manipulating metal to create objects or sculptures?",
                        options6,
                        options6.c!!
                    )
                )

                val options7 = Option("Embroidery", "Quilting", "Crocheting", "Knitting")
                artAndCraftQuestions.add(
                    Quiz(
                        "What art form involves using needle and thread to create decorative designs on fabric?",
                        options7,
                        options7.a!!
                    )
                )

                val options8 = Option("Sculpting", "Engraving", "Glass etching", "Glassblowing")
                artAndCraftQuestions.add(
                    Quiz(
                        "Which process involves heating glass to a high temperature and shaping it using a blowpipe or molds?",
                        options8,
                        options8.d!!
                    )
                )

                val options9 = Option("Engraving", "Linocut", "Woodcut", "Etching")
                artAndCraftQuestions.add(
                    Quiz(
                        "What is the technique of creating designs by cutting into a hard surface, often wood or linoleum, and printing the image onto paper called?",
                        options9,
                        options9.c!!
                    )
                )

                artAndCraftQuestions.shuffle()
                return artAndCraftQuestions
            }

            context.getString(R.string.knowledge) -> {
                val knowledgeQuestions = mutableListOf<Quiz>()

                val options1 = Option("Australia", "Brazil", "Mexico", "Philippines")
                knowledgeQuestions.add(
                    Quiz(
                        "Which country is known for the Great Barrier Reef?",
                        options1,
                        options1.a!!
                    )
                )

                val options2 = Option("Mount Kilimanjaro", "K2", "Mount Everest", "Mount McKinley")
                knowledgeQuestions.add(
                    Quiz(
                        "What is the highest mountain in the world?",
                        options2,
                        options2.c!!
                    )
                )

                val options3 = Option("China", "Russia", "Nigeria", "United States")
                knowledgeQuestions.add(
                    Quiz(
                        "What is the largest country in the world by land area?",
                        options3,
                        options3.b!!
                    )
                )

                val options4 = Option("Mars", "Venus", "Jupiter", "Saturn")
                knowledgeQuestions.add(
                    Quiz(
                        "Which planet is known as the \"Red Planet\"?",
                        options4,
                        options4.a!!
                    )
                )

                knowledgeQuestions.shuffle()
                return knowledgeQuestions
            }

            context.getString(R.string.language) -> {
                val languageQuestions = mutableListOf<Quiz>()

                val option1 = Option("peice", "pisce", "piece", "pishe")
                languageQuestions.add(
                    Quiz(
                        "What is the correct spelling of the word that means a piece of paper used for writing or printing?",
                        option1,
                        option1.c!!
                    )
                )

                val option2 = Option("/skɛ.djul/", "/ʃɛ.dʒul/", "/skɪdʒ.ʊl/", "/ʃɪd.ʊl/")
                languageQuestions.add(
                    Quiz(
                        "What is the correct pronunciation of the word \"schedule\"?",
                        option2,
                        option2.a!!
                    )
                )

                val option3 = Option("do", "does", "did", "done")
                languageQuestions.add(
                    Quiz(
                        "Choose the correct form of the verb to fill in the blank: \"I _______ my homework yesterday.\"",
                        option3,
                        option3.c!!
                    )
                )

                val option4 = Option("I am hungry", "I am tired", "I am happy", "I am sad")
                languageQuestions.add(
                    Quiz(
                        "What is the correct translation of the sentence \"Je suis fatigué\" from French to English?",
                        option4,
                        option4.b!!
                    )
                )

                val option5 = Option("sad", "angry", "joyful", "bored")
                languageQuestions.add(
                    Quiz(
                        "Which of the following is a synonym of the word \"happy\"?",
                        option5,
                        option5.c!!
                    )
                )

                val option6 = Option("forget", "forgetting", "forgets", "forgot")
                languageQuestions.add(
                    Quiz(
                        "Choose the correct form of the verb to fill in the blank: \"She _______ her keys before leaving.\"",
                        option6,
                        option6.d!!
                    )
                )

                val option7 = Option("childs", "childrens", "child", "children")
                languageQuestions.add(
                    Quiz(
                        "What is the correct plural form of the word \"child\"?",
                        option7,
                        option7.d!!
                    )
                )

                val option8 = Option("and", "but", "with", "because")
                languageQuestions.add(
                    Quiz(
                        "Which of the following is a preposition?",
                        option8,
                        option8.c!!
                    )
                )

                val option9 = Option("go", "goes", "went", "gone")
                languageQuestions.add(
                    Quiz(
                        "What is the correct form of the verb to fill in the blank: \"They _______ to the beach every summer.\"",
                        option9,
                        option9.a!!
                    )
                )

                val option10 = Option("done", "dud", "did", "doed")
                languageQuestions.add(
                    Quiz(
                        "What is the correct past tense form of the verb \"do\"?",
                        option10,
                        option10.c!!
                    )
                )

                languageQuestions.shuffle()
                return languageQuestions
            }*/

            else -> {
                val myQuestions = mutableListOf<Quiz>()

                val options1 = Option("10", "14", "12", "24")
                myQuestions.add(
                    Quiz(
                        "Simplify the expression: 2(3 + 5) - 4",
                        options1,
                        options1.c!!
                    )
                )

                val options2 = Option("x = 8", "x = 3", "x = 1", "x = 16")
                myQuestions.add(Quiz("Solve the equation: 2x - 7 = 9", options2, options2.a!!))

                val option3 = Option(
                    "Equilateral triangle",
                    "Isosceles triangle",
                    "Scalene triangle",
                    "Right triangle"
                )
                myQuestions.add(
                    Quiz(
                        "If a triangle has angles measuring 30°, 60°, and 90°, what type of triangle is it?",
                        option3,
                        option3.d!!
                    )
                )

                myQuestions.shuffle()
                return myQuestions
            }
        }
    }
}