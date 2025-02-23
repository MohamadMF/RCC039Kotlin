package org.example

fun doLec7Codes() {
    fun checkLargest(n1: Int, n2: Int) = if (n1 > n2) n1 else n2
    fun check(text: String): Boolean {
        return text.contains('a') == true
    }

    fun check2(text: String) = (text.contains('a'))
}

fun numToHalf(maad: Int) {for (element in 1..maad / 2) println(element)}

fun tryCatch() {
    try {
        println("..")
        println(5/0)
        println("...")
    } catch (e: Exception) {
        println("Error: ${e.message}")
        //To see the name of error in run results, but exit code is 0
        println("${e.printStackTrace()}")
    }
}



