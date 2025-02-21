package org.example

// We remove the {} if we won't use any other codes in class body.
// here is constructor hidden after class name, but () as instead.
class Lec9Student(val name: String, val age: Int)

/* To not allow to repeat your code, put these properties into constructor of this class
    val name = name
    val age = age
 */

/*
    constructor (name: String, age: Int) { //setStudent
        this.name = name // 'this' is calling global properties but in inner scope
        this.age = age
    }
 */

/* To use any fun inside constructor
    fun foo() {
        println("...")
    }
    init{
        foo()
    }
 */