package com.tecacet.math.extensions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.Math.sqrt

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
    fun vectorAritmetic() {
        val v1 = doubleArrayOf(-1.0, 2.0, 3.0)
        val v2 = doubleArrayOf(1.0, -1.0, 2.5)
        val v3 = doubleArrayOf(2.0, -2.0, -2.0)

        val y = 3.5*v1 - v2*5 - v3/2
        assertEquals("[-9.5, 13.0, -1.0]", toString(y))
        assertArrayEquals(doubleArrayOf(-9.5, 13.0, -1.0), y)
    }

    @Test
    fun innerProduct() {
        val v = doubleArrayOf(1.0, -1.0, 1.0)
        val w = doubleArrayOf(1.0, 2.0, 2.0)
        assertEquals(1.0, v*w, 0.001)

        assertEquals(sqrt(3.0), v.norm(),0.001)
        assertEquals(3.0, v.normSquared(),0.001)

    }


    @Test
    fun matrixArithmetic() {
        val m1 = arrayOf(doubleArrayOf(1.0, 2.0),
            doubleArrayOf(-2.0, 1.0),
            doubleArrayOf(-1.0, -2.0))
        val m2 = arrayOf(doubleArrayOf(2.0, 1.0),
            doubleArrayOf(2.0, -1.0),
            doubleArrayOf(0.0, 1.0))

        val m = 2*m1/5.0 - 5.0*m2/2
        assertEquals(
                "[-4.6, -1.7]\n" +
                "[-5.8, 2.9]\n" +
                "[-0.4, -3.3]", toString(m))

    }

    @Test
    fun matrixVectorMultiplication() {
        var w = zeros(3)
        val g =  arrayOf(doubleArrayOf(1.0, 2.0, 1.0),
            doubleArrayOf(-2.0, 1.0, 2.0),
            doubleArrayOf(0.0, -1.0, -1.0)
        )
        val h = ones(3)

        w -= g*h
        assertArrayEquals(doubleArrayOf(-4.0, -1.0, 2.0), w)

        val v = h*g
        assertArrayEquals(doubleArrayOf(-1.0, 2.0, 2.0), v)

    }

    @Test
    fun matrixMultiplication() {
        val m = arrayOf(doubleArrayOf(1.0, 2.0),
            doubleArrayOf(-2.0, 1.0),
            doubleArrayOf(-1.0, -2.0))
        assertEquals(
            "[5.0, 0.0, -5.0]\n" +
                "[0.0, 5.0, 0.0]\n" +
                "[-5.0, 0.0, 5.0]",
            toString(m*m.transpose()))
        assertEquals(
            "[6.0, 2.0]\n" +
                    "[2.0, 9.0]",
            toString(m.transpose()*m))
    }
}
