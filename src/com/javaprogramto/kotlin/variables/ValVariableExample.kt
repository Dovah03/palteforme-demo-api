package com.javaprogramto.kotlin.variables

fun main(args: Array<String>) {

    // int type varaible with var keyword
    var number: Int = 12345;
    println("old value of number : $number")
    number = 10000
    println("new value of number : $number")


    // int type variable with val keyword
    val highestMark: Int = 99;
    println("old value of highestMark : $highestMark")
    //  highestMark = 98
    println("new value of highestMark : $highestMark")

    // long numbers with underscore for readable

    var creditCardNumber: Long = 4320_3456_9808_4389
    var debitCardNumber = 1234_45678_1234_9876L
    var timeInMilliSeconds = 60_000

    // printing
    println("Credit card number : $creditCardNumber")
    println("Debit card number : $debitCardNumber")
    println("Time in milli seconds : $timeInMilliSeconds")

    // declaring a variable with the null
    val noValue: String?

    // assigning value
    noValue = "assigned value"

    // printing the value
    println("novalue is now : $noValue")

    var number1: Int = 10;
    var number2: Long = 12345678;

    // compile time error : Kotlin: Type mismatch: inferred type is Int but Long was expected
    // number2 = number1;

    // right conversion
    number2 = number1.toLong();
    println("number 2 : $number2")

    var number3 = 10;
    var number4 = 12345678;

    // no compile time error
    number4 = number3;

    println("number4 : $number4")


    // variable with null type and value assignment
    var number5: Int? = 100
    var number6: Long? = 200

    // compile time error - Kotlin: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Int?
    // number6 = number5.toLong()

    // no error with null safe
    number6 = number5?.toLong();

    println("number 6 : $number6")


    // Numbers
    // Byte : range -128 to 127
    var byteVar: Byte = 100
    println("Byte variable : $byteVar")

    // Short : range -32768 to 32767
    var shortVar: Short = -1000
    println("Short variable : $shortVar")

    // Int : range -2^31 to 2^31-1
    var intVar: Int = 12345
    println("Int variable : $intVar")

    // Long : range -2^63 to 2^63-1
    var longVar: Long = 12345678900
    println("Long variable : $longVar")

    // Float : single precision 32 bit float point
    var floatVar: Float = 123.4F // F is mandatory at end else compile time error
    println("Float variable : $floatVar")

    // Double : precision 64 bit floating value
    var doubleVar: Double = 1234.56
    println("Double variable : $doubleVar")


    // Characters
    // Char
    var charVar: Char = 'A'
    println("Char variable : $charVar")

    // Boolean - this takes only two values - true/false
    var booleanVar: Boolean = true
    println("Boolean variable : $booleanVar")

    var booleanVarFalse: Boolean = false
    println("Boolean variable false : $booleanVarFalse")

    // Arrays
    // implicit type declaration
    var array1  = listOf(1,2,3,4,5)

    // explcit type declaration
    var array2  = listOf<Long>(1,2,3,4,5)


}