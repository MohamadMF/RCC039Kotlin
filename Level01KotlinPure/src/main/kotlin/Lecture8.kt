package org.example

fun doLec8Codes() {
    //Copy - Instance - Object
    val student = Lec8Student()

    student.name = "Candroid"
    student.age = 15

    println(student.name)
    println(student.age)

    val user = Lec8User()
    user.password = "1234"
    println(user.password)

}

fun doLec8Exercise() {
    val s1 = Lec8ExerciseStudent()
    s1.age = 2

    val s2 = Lec8ExerciseStudent()
    s2.age = 6
}
