package com.javaprogramto.kotlin.collections.map.list

import java.util.HashMap

fun main(array: Array<String>) {

    var map = HashMap<Int, String>();

    map[10] = "Ten"
    map[20] = "Twenty"
    map[30] = "Thirty"
    map[40] = "Fourty"
    map[50] = "Fifty"

    // example 1 using toList() method
    var keysList = map.keys.toList();
    var valuesList = map.values.toList();
    println("using toList()")
    println("Keys list : $keysList")
    println("Values list : $valuesList")

    // example 2 using toList() method

    var mutableMap: MutableMap<Int, String> = HashMap()
    mutableMap[10] = "Ten"
    mutableMap[20] = "Twenty"
    mutableMap[30] = "Thirty"
    mutableMap[40] = "Fourty"
    mutableMap[50] = "Fifty"

    var entries = mutableMap.toList().map { "(${it.first}, ${it.second})"}
    println("\nusing toList() on mutable map")
    entries.forEach{print("$it ")}


}