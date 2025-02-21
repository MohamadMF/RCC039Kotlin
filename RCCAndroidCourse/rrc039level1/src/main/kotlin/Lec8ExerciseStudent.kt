package org.example

class Lec8ExerciseStudent {
    var age = 0
        set(value) {
            if (value < 5) {
                println("Age is not valid")
            }
            else {
                //field = value
                println("Age saved successfully")
            }
        }
    /*
    val s1 = Lec8Student()
    s1.age = 2
    if (s1.age < 5)
        println("Age is not valid")
    else
        println("Age saved successfully")

    val s2 = Lec8Student()
    s2.age = 6
    if (s2.age < 5)
        println("Age is not valid")
    else
        println("Age saved successfully")
     */
}