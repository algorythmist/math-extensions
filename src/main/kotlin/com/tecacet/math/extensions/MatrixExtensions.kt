package com.tecacet.math.extensions

import java.util.*

typealias Vector = DoubleArray
typealias Matrix = Array<DoubleArray>

//VECTOR OPERATIONS

operator fun DoubleArray.unaryMinus() = this.map { -it }.toDoubleArray()

/**
 * vector scalar multiplication
 */
operator fun DoubleArray.times(scalar: Number) = this.map { v -> v * scalar.toDouble() }.toDoubleArray()

/**
 * scalar vector multiplication
 */
operator fun Number.times(x: DoubleArray) = x * this

/**
 * vector scalar division
 */
operator fun DoubleArray.div(scalar: Number) = this.map { v -> v / scalar.toDouble() }.toDoubleArray()

/**
 * Vector Addition
 * WARNING: Unless explicitly imported, + defaults to array concatenation
 */
operator fun DoubleArray.plus(x: DoubleArray) = this.indices.map { this[it] + x[it] }.toDoubleArray()

/**
 * Vector subtraction
 */
operator fun DoubleArray.minus(x: DoubleArray) = this.indices.map { this[it] - x[it] }.toDoubleArray()

/**
 * Inner Product
 */
operator fun DoubleArray.times(v: DoubleArray) = this.indices.map { this[it] * v[it] }.sum()

/**
 * Inner Product with int array
 */
operator fun DoubleArray.times(v: IntArray) = this.indices.map { this[it] * v[it] }.sum()

/**
 * First index that achieves the maximum value
 */
fun DoubleArray.argmax() = (0 until this.size).maxBy { this[it] }

fun DoubleArray.normSquared() = this * this
fun DoubleArray.norm() = Math.sqrt(this.normSquared())

/**
 * Create a vector of ones
 */
fun ones(dimension: Int) = DoubleArray(dimension) { 1.0 }

/**
 * Create a vector of zeros
 */
fun zeros(dimension: Int) = DoubleArray(dimension) { 0.0 }

/**
 * Create a coordinate vector of dimension <code>dimension</code> with 1 in <code>index</code> and 0 elsewhere
 * @param dimension the dimension of the vector
 * @param index the index to set to 1
 */
fun coordinate(dimension: Int, index: Int): DoubleArray {
    val v = DoubleArray(dimension) { 0.0 }
    v[index] = 1.0
    return v
}

fun toString(v: Vector): String = Arrays.toString(v)

//MATRIX OPERATIONS

/**
 * Get the ith row of a matrix
 */
fun Array<DoubleArray>.row(i: Int) = this[i]

/**
 * Number of rows
 */
fun Array<DoubleArray>.rows() = this.size

/**
 * Number of columns
 */
fun Array<DoubleArray>.columns() = if (this.isEmpty()) 0 else this[0].size

/**
 * Matrix-scalar multiplication
 */
operator fun Array<DoubleArray>.times(scalar: Number): Array<DoubleArray> {
    val X = doubleMatrix(this.rows(), this.columns())
    for (i in 0 until this.rows()) {
        for (j in 0 until this.columns()) {
            X[i][j] = this[i][j] * scalar.toDouble()
        }
    }
    return X
}

operator fun Array<DoubleArray>.unaryMinus() = this * -1

/**
 * Scalar-matrix multiplication
 */
operator fun Number.times(A: Array<DoubleArray>): Array<DoubleArray> = A * this

/**
 * Matrix-scalar division
 */
operator fun Array<DoubleArray>.div(scalar: Number) = this.times(1.0 / scalar.toDouble())

/**
 * Convert an IntArray to DoubleArray
 */
fun IntArray.toDoubleArray() = this.map { it.toDouble() }.toDoubleArray()


/**
 * Add two matrices
 */
operator fun Array<DoubleArray>.plus(A: Array<DoubleArray>): Array<DoubleArray> {
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
operator fun Array<DoubleArray>.minus(A: Array<DoubleArray>): Array<DoubleArray> {
    val X = doubleMatrix(this.rows(), this.columns())
    for (i in 0 until this.rows()) {
        for (j in 0 until this.columns()) {
            X[i][j] = this[i][j] - A[i][j]
        }
    }
    return X
}

/**
 * Matrix-vector multiplication
 */
operator fun Array<DoubleArray>.times(x: DoubleArray): DoubleArray {
    if (this.columns() != x.size) throw IllegalArgumentException("Incompatible sizes")
    return (0 until this.rows()).map { this[it] * x }.toDoubleArray()
}

/**
 * Matrix multiplication
 */
operator fun Matrix.times(A: Matrix): Matrix {
    if (rows() != A.columns()) throw IllegalArgumentException("Incompatible dimensions")
    return (0 until this.rows()).map { this[it] * A }.toTypedArray()
}

/**
 * Matrix multiplication with vector of integers
 */
operator fun Array<DoubleArray>.times(x: IntArray): DoubleArray = this * x.toDoubleArray()

/**
 * Vector-matrix multiplication
 */
operator fun DoubleArray.times(A: Array<DoubleArray>): DoubleArray {
    if (this.size != A.rows()) throw IllegalArgumentException("Incompatible sizes")
    val y = DoubleArray(A.columns())
    for (j in 0 until A.rows()) {
        for (i in 0 until A.columns()) {
            y[i] += A[j][i] * this[j]
        }
    }
    return y
}

/**
 * Transpose matrix
 */
fun Array<DoubleArray>.transpose(): Array<DoubleArray> {
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

fun toString(matrix: Array<DoubleArray>): String {
    return (0 until matrix.rows()).map { toString(matrix[it]) }.joinToString("\n")
}

/**
 * Create a unit matrix of the given dimension
 */
fun unit(dimension: Int) = Array(dimension) { i -> DoubleArray(dimension) { j -> if (i == j) 1.0 else 0.0 } }

//double array initialization
fun intMatrix(sizeOuter: Int, sizeInner: Int): Array<IntArray> = Array(sizeOuter) { IntArray(sizeInner) }
fun doubleMatrix(sizeOuter: Int, sizeInner: Int): Array<DoubleArray> = Array(sizeOuter) { DoubleArray(sizeInner) }
