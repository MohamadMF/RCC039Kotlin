package org.example

import java.text.SimpleDateFormat
import java.util.*

fun doLec4Codes() {
    /* String Tamplets
        If I want to print Float or Double number _
        with roundup, It's by "%.2f" as 2 means two decimal numbers.

        If I want to print Int number _
        with commas, It's by "%,d".
     */
    val number = 614981.15
    val formattedTextFieldUI = "%,2f".format(number)
    println(formattedTextFieldUI)

    //If expression has already explained

    val grade = 90

    when (grade) {
        90, 91, 92 -> {
            print("Great")
            println("A+")
        }

        80 -> println("B")
        else -> println("Restest again")
    }

    when (grade) {
        in 50..100-> println("Pass!")
        !in 50..100-> println("Fail!")
    }

    val type = '@'
    when (type) { // .. as riseTo
        in 'a' .. 'z', in 'A'..'Z' -> println("Letter is found")
        in '0'..'9' -> println("Number is found")
        else -> println("Others are found")
    }

    for (i in 50 downTo  1 step 5) { //step as a jump state.
        println(1)
    }
    for (i in 1..101 step 4) {
        println(i)
    }

    var x = 1
    while (x <=3) {
        println("x step $x")
        ++x
    }
    println("x after end is $x")

    while (x in 1 until 6) { //it will end at 5 with until
        println("x step $x")
        ++x // it won't execute no.6
    }
    println("x after end is $x")
}

fun doLec4Excerises() {
    /*
    Groot loves to say his name. Write a program that prints
    “I AM GROOT” 6 times using the while loop
     */
    var groot = 1
    while (groot in 1 .. 6) {
        println("I'm groot no.$groot")
        groot++
    }

    /*
    Write a program that prints all the numbers that are divisible by 6
    from 1 to 100
     */
    var range = 1
    for (range in 1 .. 100){
        if (range % 6 == 0) {
            println("$range is a number can mod on 6")
        }
    }

}

fun doLec4MainMission() {
    /*
    - Write a program that prints the grade of a student, if his total is
    above or equals to 90 then print A+, if his total is above or equals
    to 75 then print B , if his total is above or equals to 50 then print
    D+, otherwise print D.
    - Assume that the student has a total of 72.
    - Solve this mission using if, else & when expressions.
     */
    val examResult = 89
    when (examResult) {
        in 90 .. 100 -> println("A+")
        in 75 until 90 -> println("B")
        in 50 until 75 -> println("D+")
        else -> println("D")
    }
}

fun doLec4ExtraMission() {
    /*
    - My Etisalat App is giving daily Social Megabytes gifts
    for the users. Write a program that checks the
    current day , then sends the users free Social
    Megabytes according to that day.
    - It is better to use when expression when there are
    more than two branches and this program contains 5 branches.
     */
    // As Eng. Ahmad Atef needs
    val dayGift = 3
    when (dayGift) {
        1 -> println("Day 1. You got 20 Megabytes")
        2 -> println("Day 2. You got 25 Megabytes")
        3 -> println("Day 3. You got 25 Megabytes")
        4 -> println("Day 4. You got 30 Megabytes")
        5 -> println("Day 5. You got 30 Megabytes")
    }

    // As my expectation for more efficient code
    val startDay = 1
    val startMegabytes = 20
    val totalDays = 5

    for (i in 0 until totalDays) {
        val currentDay = startDay + i
        val currentMegabytes = startMegabytes + (i * 5)
        println("Day $currentDay. You got $currentMegabytes megabytes")
    }
}