package com.tecacet.math.permutations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PermutationsTest {

    @Test
    fun identity() {
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), identity(5))
    }

    @Test
    fun swap() {
        val permutation = intArrayOf(1, 0, 3, 2)
        swap(permutation, 0, 2)
        assertArrayEquals(intArrayOf(3, 0, 1, 2), permutation)
    }

    @Test
    fun compose() {
        val permutation1 = intArrayOf(2, 1, 0, 3)
        val permutation2 = intArrayOf(1, 0, 3, 2)
        val composite = compose(permutation1, permutation2)
        assertArrayEquals(intArrayOf(1, 2, 3, 0), composite)
    }

    @Test
    fun inverse() {
        val permutation = intArrayOf(1, 3, 4, 2, 0)
        val inverse = inverse(permutation)
        assertArrayEquals(intArrayOf(4, 0, 3, 1, 2), inverse)
        //verify that the composition with the inverse gives the identity permutation
        val composite = compose(permutation, inverse)
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), composite)
    }

    @Test
    fun reverse() {
        val permutation = intArrayOf(1, 3, 4, 2, 0, 5)
        reverse(permutation, 1, 4)
        assertEquals("[1, 2, 4, 3, 0, 5]", permutation.contentToString())
    }

    @Test
    fun isValid() {
        assertTrue(isValid(intArrayOf(1, 3, 4, 2, 0, 5)))
        assertFalse(isValid(intArrayOf(1, 3, 4, 2, 5)))
        assertFalse(isValid(intArrayOf(1, 3, 4, -2, 0, 5)))
        assertFalse(isValid(intArrayOf(1, 3, 4, 2, 0, 5, 2)))
        assertTrue(isValid(intArrayOf(0, 3, 2, 5, 4, 1)))

    }
}
