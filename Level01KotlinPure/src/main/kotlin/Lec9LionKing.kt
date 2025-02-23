package org.example

//to import all funs of parent class, use
class Lec9LionKing : Lec9Movie() {

    //to call any fund of parent class, write any 3 letters of that fun
    override fun printQuote() {
        super.printQuote()
        println("Hakuna Matta")
    }
}