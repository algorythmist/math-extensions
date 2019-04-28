package com.tecacet.math.extensions

import java.lang.IllegalArgumentException
import java.util.*

typealias Vector = DoubleArray
typealias Matrix = Array<DoubleArray>

//vector scalar multiplication
operator fun DoubleArray.times(scalar : Number) = this.map { v -> v*scalar.toDouble() }.toDoubleArray()
operator fun Number.times(x : DoubleArray) = x*this

//vector scalar division
operator fun DoubleArray.div(scalar : Number) = this.map { v -> v/scalar.toDouble() }.toDoubleArray()

/**
 * Vector Addition
 * WARNING: Unless explicitly imported, + defaults to array concatenation
 */
operator fun DoubleArray.plus(x : DoubleArray) = this.indices.map { this[it] + x[it] }.toDoubleArray()

/**
 * Vector subtraction
 */
operator fun DoubleArray.minus(x : DoubleArray) = this.indices.map { this[it] - x[it] }.toDoubleArray()

//inner product
operator fun DoubleArray.times(v : DoubleArray) = this.indices.map { this[it]*v[it] }.sum()
operator fun DoubleArray.times(v : IntArray) = this.indices.map { this[it]*v[it] }.sum()

fun DoubleArray.argmax() = (0 until this.size).maxBy { this[it] }

fun DoubleArray.normSquared() = this*this
fun DoubleArray.norm() = Math.sqrt(this.normSquared())

//matrix scalar operations
operator fun Array<DoubleArray>.times(scalar : Number) : Array<DoubleArray> {
    val X = doubleMatrix(this.rows(), this.columns())
    for (i in 0 until this.rows()) {
        for (j in 0 until this.columns()) {
            X[i][j] = this[i][j] * scalar.toDouble()
        }
    }
    return X
}

operator fun Number.times(A : Array<DoubleArray>) : Array<DoubleArray> = A*this

operator fun Array<DoubleArray>.div(scalar : Number) = this.times(1.0/scalar.toDouble())

//Int to Double
fun IntArray.toDoubleArray() = this.map { it.toDouble() }.toDoubleArray()

/**
 * Create a coordinate vector of dimension $dimension with 1 in $index and 0 elsewhere
 * @param dimension the dimension of the vector
 * @param index the index to set to 1
 */
fun coordinate(dimension : Int, index : Int) : DoubleArray {
    val v =  DoubleArray(dimension) {0.0}
    v[index] = 1.0
    return v
}

fun ones(dimension: Int) = DoubleArray(dimension) { _ -> 1.0}
fun zeros(dimension: Int) = DoubleArray(dimension) { _ -> 0.0}

fun toString(v : Vector) = Arrays.toString(v)

/**
 * Add two matrices
 */
operator fun Array<DoubleArray>.plus(A : Array<DoubleArray>) : Array<DoubleArray> {
    val X = doubleMatrix(this.rows(), this.columns())
    for (i in 0 until this.rows()) {
        for (j in 0 until this.columns()) {
            X[i][j] = this[i][j] + A[i][j]
        }
    }
    return X
}

/**
 * Subtract two matrices
 */
operator fun Array<DoubleArray>.minus(A : Array<DoubleArray>) : Array<DoubleArray> {
    val X = doubleMatrix(this.rows(), this.columns())
    for (i in 0 until this.rows()) {
        for (j in 0 until this.columns()) {
            X[i][j] = this[i][j] - A[i][j]
        }
    }
    return X
}

/**
 * matrix vector multiplication
 */
operator fun Array<DoubleArray>.times(x : DoubleArray) : DoubleArray {
    if (this.columns() != x.size) throw IllegalArgumentException("Incompatible sizes")
    return (0 until this.rows()).map { this[it]* x}.toDoubleArray()
}

/**
 * Matrix multiplication
 */
operator fun Matrix.times(A : Matrix) : Matrix {
    if (rows() != A.columns()) throw IllegalArgumentException("Incompatible dimensions")
    return (0 until this.rows()).map { this[it]*A }.toTypedArray()
}

/**
 * vector matrix multiplication
 */
operator fun Array<DoubleArray>.times(x : IntArray) : DoubleArray {
    if (this.columns() != x.size) throw IllegalArgumentException("Incompatible sizes")
    val y = DoubleArray(this.size)
    for (j in 0 until this.size) {
        for (i in 0 until this[j].size) {
            y[j] += this[j][i] * x[i]
        }
    }
    return y
}

/**
 * vector matrix multiplication
 */
operator fun DoubleArray.times(A : Array<DoubleArray>) : DoubleArray {
    if (this.size != A.rows()) throw IllegalArgumentException("Incompatible sizes")
    val y = DoubleArray(A.columns())
    for (j in 0 until A.rows()) {
        for (i in 0 until A.columns()) {
            y[i] += A[j][i] * this[j]
        }
    }
    return y
}

fun Array<DoubleArray>.row(i : Int) = this[i]
fun Array<DoubleArray>.rows() = this.size
fun Array<DoubleArray>.columns() = if (this.isEmpty()) 0 else this[0].size

fun Array<DoubleArray>.transpose() : Array<DoubleArray> {
    if (this.isEmpty()) {
        return this
    }
    val t = doubleMatrix(this.columns(), this.rows())
    for (i in 0 until this.columns()) {
        for (j in 0 until this.rows()) {
            t[i][j] = this[j][i]
        }
    }
    return t
}

fun toString(matrix : Array<DoubleArray>) : String {
    return (0 until matrix.rows()).map { toString(matrix[it]) }.joinToString ("\n" )
}

//double array initialization
fun intMatrix(sizeOuter: Int, sizeInner: Int): Array<IntArray>
        = Array(sizeOuter) { IntArray(sizeInner) }
fun doubleMatrix(sizeOuter: Int, sizeInner: Int): Array<DoubleArray>
        = Array(sizeOuter) { DoubleArray(sizeInner) }
