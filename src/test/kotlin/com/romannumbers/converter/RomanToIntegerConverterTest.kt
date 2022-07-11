package com.romannumbers.converter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RomanToIntegerConverterTest {

    @Test
    fun `test exact literals`() {
        assertEquals(10, romanToInteger("X"))
        assertEquals(50, romanToInteger("L"))
        assertEquals(100, romanToInteger("C"))
        assertEquals(500, romanToInteger("D"))
        assertEquals(1000, romanToInteger("M"))
    }

    @Test
    fun `test numbers in units`() {
        assertEquals(2, romanToInteger("II"))
        assertEquals(4, romanToInteger("IV"))
        assertEquals(5, romanToInteger("V"))
        assertEquals(9, romanToInteger("IX"))
    }

    @Test
    fun `test numbers in tens`() {
        assertEquals(18, romanToInteger("XVIII"))
        assertEquals(45, romanToInteger("XLV"))
        assertEquals(85, romanToInteger("LXXXV"))
        assertEquals(90, romanToInteger("XC"))
    }

    @Test
    fun `test numbers in hundreds`() {
        assertEquals(945, romanToInteger("CMXLV"))
        assertEquals(375, romanToInteger("CCCLXXV"))
        assertEquals(550, romanToInteger("DL"))
        assertEquals(825, romanToInteger("DCCCXXV"))
    }

    @Test
    fun `test numbers in thousands`() {
        assertEquals(1050, romanToInteger("ML"))
        assertEquals(1275, romanToInteger("MCCLXXV"))
        assertEquals(1875, romanToInteger("MDCCCLXXV"))
        assertEquals(2475, romanToInteger("MMCDLXXV"))
    }

    @Test
    fun `test out of boundary numbers`() {
        val exception = assertThrows<RuntimeException> {
            romanToInteger("MMMM")
        }
        assertEquals("Conversion is supported for numbers <= 3000 only", exception.message)
    }

    @Test
    fun `test unknown literals`() {
        val exception = assertThrows<RuntimeException> {
            romanToInteger("AB")
        }
        assertEquals("Unknown roman literal A", exception.message)
    }
}
