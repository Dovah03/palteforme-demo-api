package com.javaprogramto.kotlin.conversions

fun main(args: Array<String>) {

    var str : String = "456.75F"
    var float3 = str.toFloatOrNull();
    println("string to float - float3 $float3")

    var str2 : String = "PI3.14"
    var float4 = str2.toFloatOrNull();
    println("string to float - float4 $float4")
}