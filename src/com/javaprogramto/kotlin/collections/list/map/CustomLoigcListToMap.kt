package com.javaprogramto.kotlin.collections.list.map

// kotlin program to convert list to map using map() and toMap() methods.
fun main(args: Array<String>) {
    var websiteranks: List<Website> = listOf(
        Website("google.com", 1),
        Website("youtube.com", 2),
        Website("amazon.com", 3),
        Website("yahoo.com", 4)
    );

    val finalMap: MutableMap<String, Long> = HashMap();

    for (website in websiteranks) {
        finalMap[website.site] = website.rank;
    }

    println("Map from list using custom iterating the list with for loop : $finalMap")

}