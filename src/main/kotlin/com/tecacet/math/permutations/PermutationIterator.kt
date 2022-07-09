package com.tecacet.math.permutations

import kotlin.NoSuchElementException

/**
 * Iterate over all permutations for a set of given order.
 * WARNING: If you try to iterate all permutations of a large set, it will probably
 * take an exceeding long time.
 *
 * @property order the order of the permutation
 * @constructor creates an iterator for permutations of the given order
 */
class PermutationIterator(private val order : Int) : Iterator<IntArray> {

    private var currentElement = 0
    private val current = IntArray(order) { i -> i}
    private val last = IntArray(order) { i -> order-i-1}

    override fun hasNext() = !current.contentEquals(last)

    override fun next(): IntArray {
        if (!hasNext()) {
            throw NoSuchElementException("The set of $order elements has no more permutations")
        }
        if (0 != currentElement) {
            getNext(current)
        }
        currentElement++
        return current.copyOf()
    }

    private fun getNext(permutation: IntArray) {
        var i = permutation.size - 1
        while (permutation[i - 1] >= permutation[i]) i--
        var j = permutation.size
        while (permutation[j - 1] <= permutation[i - 1]) j--

        swap(permutation,i - 1, j - 1 )
        i++
        j = permutation.size

        while (i < j) {
            swap(permutation,i - 1, j - 1)
            i++
            j--
        }
    }
}
