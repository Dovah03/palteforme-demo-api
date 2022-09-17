package com.javaprogramto.kotlin.collections.list.map

fun main(args: Array<String>){
    var websiteranks: List<Website> = listOf(
        Website("google.com", 1),
        Website("youtube.com", 2),
        Website("amazon.com", 3),
        Website("yahoo.com", 4)
    );

    val finalMap : Map<String, Long> = websiteranks.associateBy({it.site}, {it.rank});

    println("Final map from list using associateBy: $finalMap")

    val mapValueCustomType : Map<String, Website> = websiteranks.associateBy({it.site}, {it})
    println("Map value as custom type using associateBy : $mapValueCustomType")

}