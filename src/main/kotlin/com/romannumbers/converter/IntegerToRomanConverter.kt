package com.romannumbers.converter

private val thousands: Array<String> = arrayOf("", "M", "MM", "MMM")
private val hundreds: Array<String> = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
private val tens: Array<String> = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
private val units: Array<String> = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

fun integerToRoman(number: Int): String {
    if (number < 1 || number > 3000)
        throw RuntimeException("Please enter a number between 1 and 3000")

    return thousands[number / 1000] +
            hundreds[(number % 1000) / 100] +
            tens[(number % 100) / 10] +
            units[number % 10]
}
