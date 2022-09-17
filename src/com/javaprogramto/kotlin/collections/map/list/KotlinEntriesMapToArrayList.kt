package com.javaprogramto.kotlin.collections.map.list

import java.util.HashMap

fun main(array: Array<String>) {

    var mutableMap: MutableMap<Int, String> = HashMap()

    mutableMap[10] = "Ten"
    mutableMap[20] = "Twenty"
    mutableMap[30] = "Thirty"
    mutableMap[40] = "Fourty"
    mutableMap[50] = "Fifty"

    var list : List<String> = mutableMap.entries.map { ("${it.key} -->  ${it.value}") }

    list.forEach{println(it)}
}