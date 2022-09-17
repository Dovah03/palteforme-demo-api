package com.javaprogramto.kotlin.collections.map.list

import java.util.HashMap

fun main(array: Array<String>) {

    // to holds the insertion order
    var map = LinkedHashMap<Int, String>();

    map.put(10, "Ten")
    map.put(20, "Twenty")
    map.put(30, "Thirty")
    map.put(40, "Fourty")
    map.put(50, "Fifty")

    // gets the keys and values as per the insertion
    var keysList = ArrayList(map.keys);
    var valuesList = ArrayList(map.values);

    // prints
    println("Keys list : $keysList")
    println("Values list : $valuesList")
}