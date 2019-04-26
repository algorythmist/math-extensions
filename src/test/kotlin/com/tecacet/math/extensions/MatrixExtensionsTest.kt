package com.tecacet.math.extensions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class MatrixExtensionsTest {

    @Test
    fun doubleMatrix() {
        val m = arrayOf(doubleArrayOf(1.0, 2.0),
            doubleArrayOf(-2.0, 1.0),
            doubleArrayOf(-1.0, -2.0))
        assertEquals(3, m.rows())
        assertEquals(2, m.columns())
        assertArrayEquals(doubleArrayOf(-2.0, 1.0), m.row(1))

        val t = m.transpose()
        assertEquals(2, t.rows())
        assertEquals(3, t.columns())
        assertArrayEquals(doubleArrayOf(2.0, 1.0, -2.0), t.row(1))

    }

    @Test
    fun vectorOperations() {
        var v = doubleArrayOf(-1.0, 2.0, 1.5)
        var w = doubleArrayOf(1.0, -1.0, 0.5)
        assertArrayEquals(doubleArrayOf(0.0, 1.0, 2.0), v+w)
        assertArrayEquals(doubleArrayOf(-2.0, 3.0, 1.0), v-w)

        v += w
        assertArrayEquals(doubleArrayOf(0.0, 1.0, 2.0), v)
        assertArrayEquals(doubleArrayOf(0.0, 2.0, 4.0), v*2.0)
        assertArrayEquals(doubleArrayOf(0.0, 0.25, 0.5), v/4.0)

        w -= w
        assertArrayEquals(doubleArrayOf(0.0, 0.0, 0.0), w)
    }

    @Test
    fun argmax() {
        val v = doubleArrayOf(1.0, 2.0, 3.0, 2.0, 3.0, -1.0)
        assertEquals(2, v.argmax())
    }

    @Test
    fun vectorMatrixOperations() {
        val m = arrayOf(doubleArrayOf(1.0, 2.0),
            doubleArrayOf(-2.0, 1.0),
            doubleArrayOf(-1.0, -2.0))
        val v = doubleArrayOf(1.0, -1.0)
        assertArrayEquals(doubleArrayOf(-1.0, -3.0, 1.0), m*v)

        val w = doubleArrayOf(-1.0, 0.0, 1.0)
        assertArrayEquals(doubleArrayOf(-2.0, -4.0), w*m)
    }

    @Test
    fun vectorsAndScalars() {
        val v1 = doubleArrayOf(-1.0, 2.0, 1.5)
        val v2 = doubleArrayOf(1.0, -1.0, 0.5)
        val v3 = doubleArrayOf(2.0, -2.0, -0.5)

        val y = 3.5*v1 - v2*5 - v3
        assertArrayEquals(doubleArrayOf(-10.5, 14.0, 3.25), y)
    }


}
