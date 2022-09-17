package com.javaprogramto.kotlin.variables

fun main(args: Array<String>) {

    // double type
    var pi : Double = 3.14
    println("Double PI value $pi")

    // without type but it takes the double type internally based on the value
    var doubleValue = 3.14;
    println("Default type double : doubleValue")

    // Without type but it takes as String type from assigned value
    var welcome = "hello world"
    println("string welcome note $welcome")
    welcome.toUpperCase()

    var str : String = "i am string"
    println("string type note $str")
}