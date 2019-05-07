package com.tecacet.math.extensions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BooleanExtensionsTest {

    @Test
    fun conversions() {
        assertEquals(1, true.toInt())
        assertEquals(0, false.toInt())

        assertEquals(1.0, true.toDouble(), 0.001)
        assertEquals(0.0, false.toDouble(), 0.001)

    }

    @Test
    fun booleanVectors() {
        val b1 = booleanArrayOf(false, true, true, false, true)
        val b2 = booleanArrayOf(true, true, true, true, false)

        assertArrayEquals(booleanArrayOf(true, false, false, true, false),
            !b1)

        assertArrayEquals(booleanArrayOf(false, true, true, false, false),
            b1 and b2)

        assertArrayEquals(booleanArrayOf(true, true, true, true, true),
            b1 or b2)

        assertArrayEquals(booleanArrayOf(true, false, false, true, true),
                b1 xor b2)

    }
}
