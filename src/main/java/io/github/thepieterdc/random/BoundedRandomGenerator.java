/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

/**
 * A generator for random values between a lower and upper bound.
 *
 * @param <T> type class of the generated value
 */
public interface BoundedRandomGenerator<T> extends RandomGenerator<T> {
	/**
	 * Generates a random value between the lower (inclusive) and upper
	 * (exclusive) bounds.
	 * <p>
	 * lowerInclusive <= returned value < upperExclusive
	 *
	 * @param lowerInclusive the lower bound
	 * @param upperExclusive the upper bound
	 * @return random value
	 */
	T between(T lowerInclusive, T upperExclusive);
}
