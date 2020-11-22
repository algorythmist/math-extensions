package com.tecacet.math.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

internal class RandomExtensionsTest {

    @Test
    fun randomExtensions() {
        val random = Random(178)
        val count = random.nextBinomial(10, 0.5)
        assertEquals(6, count)

        assertTrue(random.nextBoolean(0.9))

        val u = random.nextUniform(-2.0, -1.0)
        assertTrue(u > -2.0 && u < -1.0)

        val g = random.nextGaussian(10.0, 0.1)
        assertTrue(g > 9.5 && g < 10.5)

        val e = random.nextExponential(2.0)
        println(e)
    }
}
