package org.example
//this as helper class ONLY and no separate usage for 'this'
//when you determine abstract for 'fun' or 'val/var', you must determine in whole class firstly
abstract class Lec10LivingSpace {
    abstract fun addApartment()
    abstract fun addVilla()
    abstract fun addHousing()
    fun acceptedPolicy(hasAcceptedPolicy: Boolean) {
        println("Accept Terms:...${hasAcceptedPolicy}")
    }
}