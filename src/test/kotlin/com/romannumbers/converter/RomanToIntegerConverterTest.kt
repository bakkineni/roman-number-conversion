package com.romannumbers.converter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RomanToIntegerConverterTest {

    @Test
    fun `test exact literals`() {
        assertEquals(10, romanToInteger("X"))
        assertEquals(50, romanToInteger("L"))
        assertEquals(100, romanToInteger("C"))
        assertEquals(500, romanToInteger("D"))
        assertEquals(1000, romanToInteger("M"))
    }
}