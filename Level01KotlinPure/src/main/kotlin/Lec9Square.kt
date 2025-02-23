package org.example

class Lec9Square : Lec9ClosedShape() {
    override fun calculateArea(length: Int, width: Int) {
        println("Square Area: ${length * width}")
    }
}