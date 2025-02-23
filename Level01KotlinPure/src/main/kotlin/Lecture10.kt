package org.example

fun doLec10Codes() {
    val apartment = Lec10Apartment()
    apartment.addApartment()

    val movie = Lec10LionKing()
    movie.apply { //fun to call all other fun into this object
        printQuote()
        hireDirector()
        calcBudget()
        chooseCrew()
    }

    val numbers = mutableListOf<Int>()
    numbers.add(5)
    numbers.add(2)
    numbers.add(7)
    println(numbers.size)
    numbers.clear()
    println(numbers.size)

    val contacts = mutableListOf<Lec10Contacts>()
    contacts.add(Lec10Contacts("Mohamad", "01091412022"))
    contacts.add(Lec10Contacts("Ahmad", "01113536547"))
    for (contact in contacts) {
        println("Name: ${contact.name}")
        println("Name: ${contact.phone}")
        println(".....")
    }

}

fun doLec10Exercise(){
    /*
    Bsbs is having an argument with Boby about their favorite kind of
    food, help them by creating two classes Cat and the other one is
    Dog with the method eat() as a common method among them.
    Make an instance from each class then print the result from the
    above method.
     */
    /*Solution1 (Bad)
    class Cat {
        fun eat() {
            println("Bsbs wants fish")
        }
    }
    class Dog {
        fun eat() {
            println("Bsbs wants meat")
        }
    }
     */
    /*Solution2 (OK)
    open class Animal {
        open fun eat() {}
    }
    class Cat : Animal {
        override fun eat() {
            //super.eat()
            println("Bsbs wants fish")
        }
    }
    class Dog : Animal {
        override fun eat() {
            //super.eat()
            println("Bsbs wants meat")
        }
    }
     */
    /*Solution3 (Good)
    abstract class Animal {
        abstract fun eat() {}
    }
    class Cat : Animal {
        override fun eat() {
            println("Bsbs wants fish")
        }
    }
    class Dog : Animal {
        override fun eat() {
            println("Bsbs wants meat")
        }
    }
     */

    //Solution3 (Great)
    val cat = Cat()
    cat.eat()

    val dog = Dog()
    dog.eat()

}
interface  Animal {
    fun eat()
}
class Cat : Animal {
    override fun eat() {
        println("Bsbs wants fish")
    }
}
class Dog : Animal {
    override fun eat() {
        println("Bsbs wants meat")
    }
}