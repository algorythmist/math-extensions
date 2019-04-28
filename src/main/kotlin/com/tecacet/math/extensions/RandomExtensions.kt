package com.tecacet.math.extensions

import java.util.*

/**
 * Gaussian with specific mean and standard devation
 * @param mean the mean
 * @param std the standard deviation
 */
fun Random.nextGaussian(mean : Double = 0.0, std : Double = 1.0) = std * this.nextGaussian() + mean

/**
 * Pick a number uniformly inside an interval
 * @param from start of the interval
 * @param to end of the interval
 */
fun Random.nextUniform(from : Double, to : Double) = (this.nextDouble() * (to-from)) + from

/**
 * Perform n binomial trials with probability p. Return the number of successes
 * @param n the number of trials
 * @param p the probability of success for each trial
 */
fun Random.nextBinomial(n: Int, p: Double): Int {
    if (p < 0 || p > 1) throw IllegalArgumentException("Invalid probability value $p.")
    return (0 until n).map{ _ -> nextDouble()}.filter { it < p }.count()
}

/**
 * Return true with probability p
 */
fun Random.nextBoolean(p : Double) = nextDouble() < p


