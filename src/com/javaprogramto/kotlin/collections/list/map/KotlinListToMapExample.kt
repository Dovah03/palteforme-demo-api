package com.javaprogramto.kotlin.collections.list.map

data class Website(var site: String, var rank: Long);

fun main(args: Array<String>) {

    var websiteranks: List<Website> = listOf(
        Website("google.com", 1),
        Website("youtube.com", 2),
        Website("amazon.com", 3),
        Website("yahoo.com", 4)
    );

    println("List values : $websiteranks")

    val finalMap : Map<String, Long> = websiteranks.associate { Pair(it.site, it.rank) };

    println("Final map from list using associate : $finalMap")

    val mapValueCustomType : Map<String, Website> = websiteranks.associate { Pair(it.site, it) };
    println("Map value as custom type using associate : $mapValueCustomType")

}
