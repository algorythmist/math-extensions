package com.tecacet.math.permutations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class PermutationIteratorTest {

    var expected = arrayOf(
        "[0, 1, 2, 3]",
        "[0, 1, 3, 2]",
        "[0, 2, 1, 3]",
        "[0, 2, 3, 1]",
        "[0, 3, 1, 2]",
        "[0, 3, 2, 1]",
        "[1, 0, 2, 3]",
        "[1, 0, 3, 2]",
        "[1, 2, 0, 3]",
        "[1, 2, 3, 0]",
        "[1, 3, 0, 2]",
        "[1, 3, 2, 0]",
        "[2, 0, 1, 3]",
        "[2, 0, 3, 1]",
        "[2, 1, 0, 3]",
        "[2, 1, 3, 0]",
        "[2, 3, 0, 1]",
        "[2, 3, 1, 0]",
        "[3, 0, 1, 2]",
        "[3, 0, 2, 1]",
        "[3, 1, 0, 2]",
        "[3, 1, 2, 0]",
        "[3, 2, 0, 1]",
        "[3, 2, 1, 0]"
    )

    @Test
    fun testIterator() {
        var data: IntArray
        val iter = PermutationIterator(4)
        val results = arrayOfNulls<String>(24)
        var i = 0
        while (iter.hasNext()) {
            data = iter.next()
            results[i++] = data.contentToString()
        }
        assertTrue(Arrays.equals(expected, results))
        assertFalse(iter.hasNext())
        try {
            iter.next()
            fail<String>("Should have thrown NoSuchElementException")
        } catch (nsee: NoSuchElementException) {
            assertEquals("The set of 4 elements has no more permutations", nsee.message)
        }


    }

}
