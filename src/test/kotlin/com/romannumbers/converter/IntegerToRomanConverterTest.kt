package com.romannumbers.converter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class IntegerToRomanConverterTest {

    @Test
    fun `test exact literals`() {
        assertEquals("X", integerToRoman(10))
        assertEquals("L", integerToRoman(50))
        assertEquals("C", integerToRoman(100))
        assertEquals("D", integerToRoman(500))
        assertEquals("M", integerToRoman(1000))
    }

    @Test
    fun `test numbers in units`() {
        assertEquals("II", integerToRoman(2))
        assertEquals("IV", integerToRoman(4))
        assertEquals("V", integerToRoman(5))
        assertEquals("IX", integerToRoman(9))
    }

    @Test
    fun `test numbers in tens`() {
        assertEquals("XVIII", integerToRoman(18))
        assertEquals("XLV", integerToRoman(45))
        assertEquals("LXXXV", integerToRoman(85))
        assertEquals("XC", integerToRoman(90))
    }

    @Test
    fun `test numbers in hundreds`() {
        assertEquals("CMXLV", integerToRoman(945))
        assertEquals("CCCLXXV", integerToRoman(375))
        assertEquals("DL", integerToRoman(550))
        assertEquals("DCCCXXV", integerToRoman(825))
    }

    @Test
    fun `test numbers in thousands`() {
        assertEquals("ML", integerToRoman(1050))
        assertEquals("MCCLXXV", integerToRoman(1275))
        assertEquals("MDCCCLXXV", integerToRoman(1875))
        assertEquals("MMCDLXXV", integerToRoman(2475))
    }

    @Test
    fun `test boundaries`() {
        assertEquals("I", integerToRoman(1))
        assertEquals("MMM", integerToRoman(3000))
    }

    @Test
    fun `test out of boundaries - zero`() {
        val exception = assertThrows<RuntimeException> {
            integerToRoman(0)
        }
        assertEquals("Please enter a number between 1 and 3000", exception.message)
    }

    @Test
    fun `test out of boundaries - negative`() {
        val exception = assertThrows<RuntimeException> {
            integerToRoman(-1)
        }
        assertEquals("Please enter a number between 1 and 3000", exception.message)
    }

    @Test
    fun `test out of boundaries - above 3000`() {
        val exception = assertThrows<RuntimeException> {
            integerToRoman(3001)
        }
        assertEquals("Please enter a number between 1 and 3000", exception.message)
    }
}
