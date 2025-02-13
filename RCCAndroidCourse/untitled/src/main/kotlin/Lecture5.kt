package org.example

import java.util.*

fun doLec5Codes() {
    val a = 4
    val b = 2
    val c = 9

    if (a > b && a > c) {
        println(a)
    } else if (b > a && b > c) {
        println(b)
    } else if (c > a && c > b) {
        println(c)
    } else {
        println("Nothing")
    }

    //To execute previous code in more efficient
    val winner = if (a >= b && a >= c) a else if (b >= c) b else c
    println("the winner is $winner")

    //use {} to show more results. Eash step.
    var sum = 0
    for (i in 1 .. 10) sum += i
    println(sum)

    val username: String? = null
    //Safe-call operator
    println(username?.length)
    print(">>>")

    //Elvis case is this special chars ?: --> if the code got null, will write after ?:
    val password: String? = null
    val checker = password?.length ?: "You didn't enter a password"
    println(checker)

    val numbers = arrayOf(30,31,32)
    for (x in 0 until numbers.size)
        println(numbers[x])
}

fun doLec5Exercise() {
    /*
    The mayor has an array of integers from 1..10, find the sum of the
    odd and even numbers inside the above array then print the results.
     */
    val sumArray = arrayOf(1,2,3,4,5,6,7,8,9,10)
    var sumOdd = 0
    var sumEven = 0
    for (number in sumArray) {
        if (number % 2 == 0) {
            sumEven += number
            println("${sumEven} is even num")
        }
        else if ((number % 1) == 0) {
            sumOdd += number
            println("${sumOdd} is odd num")
        }

    }
}

fun doLec5Mission() {
    /*
    You have an array of integers from 1 5 , write a program to print the
    elements of this array in reverse order.
     */
    val revArray = arrayOf(1,2,3,4,5)
    for (number in revArray) {
        revArray.reverse()
        println(revArray.indexOf(number)+1)
    }
}

fun doLec5Challenge() {
    /*
    Google has an array of Strings with 100 elements.
•
    Write a program that will print the elements that
    contain the word Android , because the user wants
    to search for it.
•
    You can check this GitHub Gist to see the array. It
    contains 10 elements with the word Android
     */
    val searchElements = arrayOf(
        "Android Upside down cake",
        "function",
        "class",
        "object",
        "inheritance",
        "polymorphism",
        "loop",
        "condition",
        "data type",
        "array",
        "list",
        "map",
        "set",
        "algorithm",
        "data structure",
        "stack",
        "queue",
        "object-oriented programming",
        "encapsulation",
        "abstraction",
        "inheritance",
        "polymorphism",
        "functional programming",
        "immutable",
        "lambda",
        "ANDROID TRAINING",
        "design pattern",
        "singleton",
        "factory",
        "adapter",
        "observer",
        "testing",
        "unit test",
        "Glass Testing",
        "Black Box testing",
        "Logcat",
        "debugging",
        "exceptions",
        "AnDrOiD Development",
        "activity",
        "fragment",
        "view",
        "layout",
        "resource",
        "lifecycle",
        "onCreate",
        "intent",
        "explicit intent",
        "implicit intent",
        "broadcast receiver",
        "permission",
        "Manifest",
        "runtime permission",
        "location",
        "camera",
        "thread",
        "Handler",
        "AsyncTask",
        "Coroutines",
        "network",
        "HTTP",
        "REST API",
        "JSON",
        "Volley",
        "Retrofit",
        "database",
        "SQLite",
        "Room",
        "Realm",
        "Firebase",
        "variable",
        "testing",
        "Espresso",
        "JUnit",
        "Android Glide GitHub",
        "deployment",
        "Gradle",
        "Android Studio",
        "Play Store",
        "Maad Coding channel",
        "Kotlin",
        "Jetpack",
        "Material Design",
        "Studio Bot",
        "Google Play",
        "Stack Overflow",
        "GitHub",
        "Android Nougat",
        "developer conference",
        "Modern aNdRoId Development",
        "Gemini API",
        "Compose",
        "AR/VR",
        "Shared Preferences",
        "Elvis Operator",
        "Android Emulator",
        "Recycler View android",
        "problem-solving",
        "learning android",
        "Adapter",
    )

    searchElements.filter {
        it.contains("Android", ignoreCase = true)
    }
        .forEach { println(it) }

}

// If I want to create like contact in Excel as an array in Kotlin
fun printAllStrings(vararg strings: String) {
    for (string in strings) {
        print(string)
    }
}

