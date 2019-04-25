package com.tecacet.math.extensions

import java.util.*

fun Random.nextGaussian(mean : Double = 0.0, std : Double = 1.0) = std * this.nextGaussian() + mean

fun Random.nextUniform(from : Double, to : Double) = (this.nextDouble() * (to-from)) + from

fun Random.nextBinomial(n: Int, p: Double): Int {
    if (p < 0 || p > 1) throw IllegalArgumentException("Invalid probability value $p.")
    return (0 until n).map{ _ -> nextDouble()}.filter { it < p }.count()
}

/**
 * Return 1 with probability p
 */
fun Random.nextBoolean(p : Double) = nextDouble() < p

fun Boolean.toInt() = if (this) 1 else 0
fun Boolean.toDouble() = if (this) 1.0 else 0.0
