package org.example

class Lec10LionKing : Lec10Movable {
    override fun hireDirector() {
        println("Zazo")
    }

    override fun chooseCrew() {
        println("Simba")
    }

    override fun calcBudget() {
        println("$10M")
    }

    override fun printQuote() {
        println("Hakuna Matata")
    }

}