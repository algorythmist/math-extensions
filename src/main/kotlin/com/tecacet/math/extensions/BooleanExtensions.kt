package com.tecacet.math.extensions

import java.util.*

fun Boolean.toInt() = if (this) 1 else 0
fun Boolean.toDouble() = if (this) 1.0 else 0.0

operator fun BooleanArray.not() : BooleanArray = this.map { !it }.toBooleanArray()

infix fun BooleanArray.and(b : BooleanArray) =
    (0 until this.size).map { this[it] && b[it] }.toBooleanArray()

infix fun BooleanArray.or(b : BooleanArray) =
    (0 until this.size).map { this[it] || b[it] }.toBooleanArray()

fun toString(b : BooleanArray) = Arrays.toString(b)
