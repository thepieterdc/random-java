/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numerical;

import io.github.thepieterdc.random.AbstractRandomGenerator;

/**
 * A random generator for long numbers.
 */
public class RandomLongGenerator extends AbstractRandomGenerator<Long> {
	public static final RandomLongGenerator ALL = RandomLongGenerator.below(Long.MAX_VALUE);
	public static final RandomLongGenerator POSITIVE = RandomLongGenerator.positiveBelow(Long.MAX_VALUE);
	
	private final long lowerBound;
	private final long upperBound;
	
	/**
	 * RandomLongGenerator constructor.
	 *
	 * @param lower lower bound (inclusive)
	 * @param upper upper bound (inclusive)
	 */
	private RandomLongGenerator(final long lower, final long upper) {
		if (lower > upper) {
			throw new IllegalArgumentException("Upper bound must be higher than lower bound.");
		}
		this.lowerBound = lower;
		this.upperBound = upper + ((upper == Long.MAX_VALUE) ? 0 : 1);
	}
	
	/**
	 * Creates a random long generator instance that generates longs in the
	 * interval [lower, Long.MAX_VALUE].
	 *
	 * @param lower the lower bound (inclusive)
	 * @return the random long generator instance
	 */
	public static RandomLongGenerator above(final long lower) {
		return new RandomLongGenerator(lower, Long.MAX_VALUE);
	}
	
	/**
	 * Creates a random long generator instance that generates longs in the
	 * interval [Long.MIN_VALUE, upper].
	 *
	 * @param upper the upper bound (inclusive)
	 * @return the random long generator instance
	 */
	public static RandomLongGenerator below(final long upper) {
		return new RandomLongGenerator(Long.MIN_VALUE, upper);
	}
	
	/**
	 * Creates a random long generator instance that generates longs in the
	 * interval [lower, upper].
	 *
	 * @param lower the lower bound (inclusive)
	 * @param upper the upper bound (inclusive)
	 * @return the random long generator instance
	 */
	public static RandomLongGenerator between(final long lower, final long upper) {
		return new RandomLongGenerator(lower, upper);
	}
	
	/**
	 * Creates a random long generator instance that generates longs in the
	 * interval [0, upper].
	 *
	 * @param upper the upper bound (inclusive)
	 * @return the random long generator instance
	 */
	public static RandomLongGenerator positiveBelow(final long upper) {
		return new RandomLongGenerator(0, upper);
	}
	
	@Override
	public Long generate() {
		return this.rng.nextLong(this.lowerBound, this.upperBound);
	}
	
	@Override
	public long getCapacity() {
		return this.upperBound - this.lowerBound;
	}
}