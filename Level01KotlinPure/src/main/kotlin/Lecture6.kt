package org.example


fun doLec6Codes() {
    // Any function created by ( fun functionName(): ReturnType {} )
    val result = getMobilePrice()
    println(result * 2)

    val z = getMobilePrice() * 2
    println(z)

    var x = getMobilePrice()
    x *= 2
    println(x)

    println(getMobilePrice() * 2)

    println(getMobilePrice() + getMobilePrice())

    println(getMobilePrice().times(2))

    val camera = 5
    val ram = 8
    val storage = 128
    val size = 6.7
    val price = getMobilePriceBySpcs(camera, ram, storage, size)
    println(price * 2)

    println("Frist ${foo()}, Second ${foo()}")
    println(foo())

    repeatLetter()
    repeatLetter('*')
    repeatLetter('*',50)
    repeatLetter(times = 50)
    repeatLetter(times = 50, letter = '@')
}

fun getMobilePrice(): Double {
    val camera = 5
    val ram = 8
    val storage = 128
    val size = 6.7

    val price = (camera * 200) + (ram * 50.6) + (storage * 20) + (size * 230)
    return price
}
fun getMobilePriceBySpcs(
    camera: Int, ram: Int, storage: Int, size: Double)
: Double {
    val price = (camera * 200) + (ram * 50.6) + (storage * 20) + (size * 230)
    return price
}
fun foo(): String {
    println("Calc foo")
    return "foo"
}
fun repeatLetter(letter: Char = '%', times: Int = 10) { // = As as Default Values
    repeat(times) {
        print(letter)
    }
    println()
}

fun doLec6Exercise() {
    /*
    Write a program that contains two decimal numbers:
•
x = 6.0
•
y = 4.0
•
then send these numbers as parameters to five functions (sum
minus multiply divide modulus), and each one prints the
result inside itself.
     */
    fun sumFun (x: Double = 6.0, y: Double = 4.0) {
        val result = x + y
        println(result)
    }
    fun minusFun (x: Double = 6.0, y: Double = 4.0) {
        val result = x - y
        println(result)
    }
    fun multiplyFun (x: Double = 6.0, y: Double = 4.0) {
        val result = x * y
        println(result)
    }
    fun divideFun (x: Double = 6.0, y: Double = 4.0) {
        val result = x / y
        println(result)
    }
    fun modulusFun (x: Double = 6.0, y: Double = 4.0) {
        val result = x % y
        println(result)
    }
    sumFun()
    minusFun()
    multiplyFun()
    divideFun()
    modulusFun()
}

fun doLec6Mission(x: Int = 7, y: Int = 8) {
    /*
    Send the numbers “7” & “8” as parameters to a function that
returns the largest number among them, then print the result to the
user in your main function.
     */
    if (x > y) println(x)
    else println(y)
}

fun doLec6ExtraMission(word1: String, word2: String) {
    /*
    Write a program that contains two strings “Hello” and the other
one is “Candroid
•
S e nd the 1 st string as a parameter to a function called “check”, the
function checks if the received string contains letter ‘ a ’ so it will
return true , otherwise the function will return false
•
Do the same steps for the 2 nd string.
•
Your main function will print the returned result.
     */
    val result = if (word1.contains('a')) println(word1)
    else if (word2.contains('a')) println(word2)
    else println("No letter found")

}