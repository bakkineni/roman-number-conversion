package com.romannumbers.converter

private val literalMap = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

fun romanToInteger(romanNumber: String): Int {
    var result = 0
    val literals = romanNumber.toCharArray()

    for (i in literals.indices) {
        val literal = literals[i]
        val currentLiteralVal = literalMap.getLiteralValue(literal)
        if (i > 0 && currentLiteralVal > literalMap.getLiteralValue(literals[i - 1])) {
            result = result + currentLiteralVal - 2 * literalMap.getLiteralValue(literals[i - 1])
        } else {
            result += currentLiteralVal
        }
    }
    if (result > 3000)
        throw RuntimeException("Conversion is supported for numbers <= 3000 only")

    return result
}

fun Map<Char, Int>.getLiteralValue(literal: Char): Int =
    this[literal] ?: throw RuntimeException("Unknown roman literal $literal")
