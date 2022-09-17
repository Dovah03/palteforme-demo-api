package com.javaprogramto.kotlin.collections.map.list

import java.util.HashMap

fun main(array: Array<String>) {

    var mutableMap: MutableMap<Int, String> = HashMap()

    mutableMap[10] = "Ten"
    mutableMap[20] = "Twenty"
    mutableMap[30] = "Thirty"
    mutableMap[40] = "Fourty"
    mutableMap[50] = "Fifty"

    var keysList : List<String> = mutableMap.keys.map { ("${it} ") }
    var valuesList : List<String> = mutableMap.values.map { ("${it} ") }

    println("---- keys list ------")
    keysList.forEach{println(it)}

    println("----- values list ------")
    valuesList.forEach{println(it)}
}