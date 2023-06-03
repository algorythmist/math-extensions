package com.tecacet.math.permutations

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class PermutationTest {

    @Test
    fun invalid() {
        assertThrows(IllegalArgumentException::class.java) { Permutation(intArrayOf(1, 0, 3, 3)) }
        assertThrows(IllegalArgumentException::class.java) { Permutation(intArrayOf(1, 0, 3, 5)) }
    }

    @Test
    fun times() {
        val permutation1 = Permutation(intArrayOf(1, 0, 3, 2))
        assertEquals(4, permutation1.size)
        val permutation2 = Permutation(intArrayOf(2, 1, 0, 3))
        val composite1 = permutation1 * permutation2
        assertArrayEquals(intArrayOf(3, 0, 1, 2), composite1.asArray())
        val composite2 = permutation2 * permutation1
        assertArrayEquals(intArrayOf(1, 2, 3, 0), composite2.asArray())
    }

    @Test
    fun times_incompatible() {
        val permutation1 = Permutation(intArrayOf(1, 0, 3, 2))
        val permutation2 = Permutation(intArrayOf(2, 1, 0, 3, 4))
        assertThrows(IllegalArgumentException::class.java) { permutation1 * permutation2 }
    }

    @Test
    fun cycle() {
        val perm = Permutation.cycle(intArrayOf(1, 3, 5), 6)
        assertArrayEquals(intArrayOf(0, 3, 2, 5, 4, 1), perm.asArray())
        val expected = "[[1, 0, 0, 0, 0, 0], [0, 0, 0, 1, 0, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 0, 0, 1], [0, 0, 0, 0, 1, 0], [0, 1, 0, 0, 0, 0]]"
        assertEquals(expected, perm.asMatrix().contentDeepToString())
    }

    @Test
    fun transposition() {
        val perm = Permutation.transposition(Pair(1, 3), 6)
        assertArrayEquals(intArrayOf(0, 3, 2, 1, 4, 5), perm.asArray())
    }

    @Test
    fun fixes() {
        val perm = Permutation.create(0, 2, 1, 5, 4, 3)
        assertEquals(setOf(0, 4), perm.fixes())
    }
}
