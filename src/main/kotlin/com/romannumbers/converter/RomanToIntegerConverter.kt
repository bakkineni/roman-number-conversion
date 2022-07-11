package com.romannumbers.converter

private val literalMap = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50, "C" to 100, "D" to 500, "M" to 1000)

fun romanToInteger(romanNumber: String): Int {
    return literalMap[romanNumber]?: -1
}