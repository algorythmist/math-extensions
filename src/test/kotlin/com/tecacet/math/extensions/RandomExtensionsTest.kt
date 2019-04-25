package com.tecacet.math.extensions

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class RandomExtensionsTest {

    @Test
    fun nextBinomial() {
        val random = Random(178)
        val count = random.nextBinomial(10, 0.5)
        assertEquals(6, count)
    }
}
