package org.example

class Lec8User {
    var userName = ""
    var email = ""
    var password = ""
        set(value) { // field identifier is for set & get ONLY in kotlin
            field = "$value${(1000..9999).random()}" //without spaces
            //IntRange means 1..10
            println("Password saved: $field")
        }
        get() = field.dropLast(4) //like LEFT & RIGHT in Excel funcs
    //'S'ettrs = 'S'ave input user data
    // 'G'etters = بت'جـ'يب ما تم حفظه


}