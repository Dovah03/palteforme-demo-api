package com.javaprogramto.kotlin.collections.list.map

// kotlin program to convert list to map using map() and toMap() methods.
fun main(args: Array<String>){
    var websiteranks: List<Website> = listOf(
        Website("google.com", 1),
        Website("youtube.com", 2),
        Website("amazon.com", 3),
        Website("yahoo.com", 4)
    );

    val finalMap : Map<Long, String> = websiteranks.map { it.rank to it.site }.toMap()

    println("Final map from list using map() and toMap() methods : $finalMap")

    val mapValueCustomType : Map<String, Website> = websiteranks.map{it.site to it}.toMap();
    println("Map value as custom type using map() and toMap() methods : $mapValueCustomType")

}