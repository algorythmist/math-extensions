package com.tecacet.math.permutations

/**
 * A permutation object, with the multipication operation as composition
 * and the not operation as inverse
 */
class Permutation(private val permutation: IntArray) {

    init {
        if (!isValid(permutation)) {
            throw IllegalArgumentException("This is not a valid permutation")
        }
    }

    val size : Int
        get() = permutation.size

    operator fun get(i : Int) = permutation[i]

    operator fun times(other: Permutation) =
        Permutation(compose(this.permutation, other.permutation))

    operator fun not() = Permutation(inverse(permutation))

    /**
     * Get the number of elements that remain fixed under this permutation
     */
    fun fixes() : Set<Int> {
        return permutation.indices.filter { permutation[it] == it }.toSet()
    }

    /**
     * Display the permutation as an array where the indices 0, 1,2,... are permuted
     */
    fun asArray() = permutation.clone()

    override fun toString(): String {
        return permutation.contentToString()
    }

    /**
     * Matrix representation of the permutation
     */
    fun asMatrix() : Array<IntArray> {
        val matrix = Array(size) {IntArray(size) {0}}
        permutation.indices.forEach{
            i -> matrix[i][get(i)] = 1
        }
        return matrix
    }

    companion object {

        fun create(vararg indices : Int) = Permutation(intArrayOf(*indices))

        fun cycle(cycle : IntArray, size : Int) : Permutation {
            val perm = identity(size)
            val cycleSize = cycle.size
            perm[cycle[cycleSize-1]] = cycle[0]
            for (i in 0 until cycleSize-1) {
                perm[cycle[i]] = cycle[i+1]
            }
            return Permutation(perm)
        }

        fun transposition(t :Pair<Int, Int>, size : Int) : Permutation {
            val perm = identity(size)
            swap(perm, t.first, t.second)
            return Permutation(perm)
        }
    }
}
