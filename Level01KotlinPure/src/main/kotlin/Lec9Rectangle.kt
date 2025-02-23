package org.example

class Lec9Rectangle : Lec9ClosedShape() {
    override fun calculateArea(length: Int, width: Int) {
        println("Rectangle Area: ${length * width}")
    }
}