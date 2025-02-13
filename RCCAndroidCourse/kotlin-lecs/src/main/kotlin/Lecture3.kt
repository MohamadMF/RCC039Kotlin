package org.example


fun doLec3Codes() {
    var address: String? = "Cairo" //To use it, you must write ? after DataType
    address = "null"
    println(address!!.length)
    println(address!!.uppercase().substring(1))

    //Ex: Not in logic
    val isLoggedIn = true
    val goToHomePage = !isLoggedIn
    println(goToHomePage)

    //Unary Operation --> all below are same result in + and - .
    var age = 20
    age = age + 1 //this line can add any numbers not 1 only. And * or / to
    age += 1 // this line like before it. But more efficient
    age++ // this line is for plus one only
    ++age // this line like before it without any changes in result.

    /*Equality Questions
    * 5 == 6
    * 5 != 6
    * 5 >= 6
    * 5 <= 6
    * 5 > 6
    * 5 < 6
     */

    /*Logical Questions
    * && AND
    * || OR
    * ! NOT
     */

    // Example 1
    val age1 = 5
    val hasSiblings = true
    val address1 = "Giza"

    val example1 = (age1 >= 5) && (hasSiblings == true) && (address1 == "Cairo")
    println(example1)

    // Example 2
    val color1 = "Blue"
    val color2 = "Yellow"


    val example2 = (color1.uppercase() == "YELLOW" && color2.uppercase() == "Blue")
            || (color2.uppercase() == "YELLOW" && color1.uppercase() == "Blue")
        println("${!example2} we cannot mix these colors")

        //println("${!example2} ok we can mix these colors")

}

fun doLec3MainMission() {
    /*
    To join the YouTube Partner Program and earn money, you
    should have 1000 subscribers at least, and 4000 public watch
    hours in the last 12 months.
    Write a program that prints whether a YouTuber can join the
    program and earn money or not using the following variables:
     */
    val subscriberNumber = 1001
    val hoursWatched = 4500
    val videoType = arrayOf("Public","Private","Unlisted","Members-Only")
    val monthesPassed = 12

    val missionResult =
        (subscriberNumber >= 1000) && (videoType.get(0) == "Public"
                && hoursWatched > 4000)
                && (monthesPassed == 12)

    println("It's ${missionResult}. Congratulaions!!." +
            " You became eligible to get earns from YouTube!")

}