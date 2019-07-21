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
 * A random generator for floating point (dp) numbers.
 */
public class RandomDoubleGenerator extends AbstractRandomGenerator<Double> {
	public static final RandomDoubleGenerator DEFAULT = RandomDoubleGenerator.positiveBelow(1);
	
	private static final double EPS = 0.00000000000000001;
	
	private final double lowerBound;
	private final double upperBound;
	
	/**
	 * RandomDoubleGenerator constructor.
	 *
	 * @param lower lower bound (inclusive)
	 * @param upper upper bound (inclusive)
	 */
	private RandomDoubleGenerator(final double lower, final double upper) {
		if (lower > upper) {
			throw new IllegalArgumentException("Upper bound must be higher than lower bound.");
		}
		this.lowerBound = lower;
		this.upperBound = upper + (Math.abs(Double.MAX_VALUE - upper) < EPS ? 0 : EPS);
	}
	
	/**
	 * Creates a random double generator instance that generates doubles in
	 * the interval [lower, Double.MAX_VALUE].
	 *
	 * @param lower the lower bound (inclusive)
	 * @return the random double generator instance
	 */
	public static RandomDoubleGenerator above(final double lower) {
		return new RandomDoubleGenerator(lower, Double.MAX_VALUE);
	}
	
	/**
	 * Creates a random double generator instance that generates doubles in
	 * the interval [Double.MIN_VALUE, upper].
	 *
	 * @param upper the upper bound (inclusive)
	 * @return the random double generator instance
	 */
	public static RandomDoubleGenerator below(final double upper) {
		return new RandomDoubleGenerator(Double.MIN_VALUE, upper);
	}
	
	/**
	 * Creates a random double generator instance that generates doubles in
	 * the interval [lower, upper].
	 *
	 * @param lower the lower bound (inclusive)
	 * @param upper the upper bound (inclusive)
	 * @return the random double generator instance
	 */
	public static RandomDoubleGenerator between(final double lower, final double upper) {
		return new RandomDoubleGenerator(lower, upper);
	}
	
	/**
	 * Creates a random double generator instance that generates doubles in
	 * the interval [0, upper].
	 *
	 * @param upper the upper bound (inclusive)
	 * @return the random double generator instance
	 */
	public static RandomDoubleGenerator positiveBelow(final double upper) {
		return new RandomDoubleGenerator(0, upper);
	}
	
	@Override
	public Double generate() {
		return this.rng.nextDouble(this.lowerBound, this.upperBound);
	}
	
	@Override
	public long getCapacity() {
		return Long.MAX_VALUE;
	}
}