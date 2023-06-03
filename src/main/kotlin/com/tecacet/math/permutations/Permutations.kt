/**
 * A permutation of order <b>n</b>is represented by an array of length n whose elements have
 * values ranging from 0 to n. So, the identity permutation of order 4 is the array (0,1,2,3).
 */
package com.tecacet.math.permutations

fun identity(size : Int) = (0 until size).map { it }.toIntArray()


/**
 * Return the inverse permutation. i.e. For permutation p, a permutation q
 * s.t p(q) * q(p) = identity
 *
 * @param permutation the permutation to be invert
 */
fun inverse(permutation: IntArray): IntArray {
    val inverse = IntArray(permutation.size)
    permutation.indices.forEach { i -> inverse[permutation[i]] = i }
    return inverse
}

/**
 * Reverse the sub-permutation specified by two indices.
 *
 * @param permutation
 * the starting permutation.
 *
 * @param point1
 * the index where reversal starts - inclusive
 * @param point2
 * the index where reversal ends - exclusive
 */
fun reverse(permutation: IntArray, point1: Int, point2: Int) {

    val size = permutation.size
    val swap = (point2 - point1 + size + 1) % (size + 1) / 2

    var j = 0
    while (j < swap) {
        val k = (point1 + j) % size
        val l = (point2 - j - 1 + size) % size
        swap(permutation, k, l)
        j++
    }
}

/**
 * Compute the composition of two permutations.
 *
 * @throws IllegalArgumentException if permutations don't have the same length
 */
@Throws(IllegalArgumentException::class)
fun compose(permutation1: IntArray, permutation2: IntArray): IntArray {
    if (permutation1.size != permutation2.size) {
        throw IllegalArgumentException("The permutations do not have the same length")
    }
    return permutation1.indices.map { permutation1[permutation2[it]] }.toIntArray()
}

/**
 * Swap the contents at indices a and b
 */
fun swap(permutation: IntArray, a: Int, b: Int) {
    permutation[a] += permutation[b]
    permutation[b] = permutation[a] - permutation[b]
    permutation[a] -= permutation[b]
}

/**
 * Verify that the permutation contains all indexes from 0 to size
 */
fun isValid(permutation: IntArray) : Boolean {
    val indices = (permutation.indices).toMutableSet()
    for (i in permutation) {
        if (i < 0 || i >= permutation.size) {
            return false
        }
        indices.remove(i)
    }
    return indices.isEmpty()
}
