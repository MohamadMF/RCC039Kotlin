package org.example

// Resume in first OOP Encap AND second OOP Inher
fun doLec9Codes() {
    val uniS = Lec9Student("Candroid",15)

    val baby = Lec9Child()
    baby.name = "Koty" //of kotlin parent :)
    baby.toy = "Teddy Bear"
    println(baby.name)
    println(baby.toy)

    val quoteMovie = Lec9LionKing()
    quoteMovie.printQuote()
}

fun doLec9Exercise() {
    /*
    • Make a Lec9ClosedShape class that contains a function to calculate
    the area of a closed shape calculateArea(length : Int, width: Int)
    which has an empty body {}, then make Square and Rectangle
    classes that extend from the Lec9ClosedShape class.

    • In both Square & Rectangle classes override calculateArea(…)
    then make an instance from both and print the result.
     */
    val printResult1 = Lec9Square()
    printResult1.calculateArea(5,7)
    val printResult2 = Lec9Rectangle()
    printResult2.calculateArea(4,4)
}