package com.javaprogramto.kotlin.conversions

fun main(args: Array<String>) {

    var str : String = "12345.678"
    var float1 : Float = str.toFloat();
    println("string to float - float1 $float1")

    var str2 : String = "A123"
    var float2 : Float = str2.toFloat();
    println("string to float - float2 $float2")

}