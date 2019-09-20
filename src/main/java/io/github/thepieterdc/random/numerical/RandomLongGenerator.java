/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numerical;

import io.github.thepieterdc.random.AbstractRandomGenerator;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * A random generator for long numbers.
 */
public class RandomLongGenerator extends AbstractRandomGenerator<Long> {
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
		this.upperBound = upper + (upper == Long.MAX_VALUE ? 0 : 1);
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
	
	/**
	 * Creates a random long generator instance that generates longs in the
	 * interval [0, Long.MAX_VALUE].
	 *
	 * @return the random long generator instance
	 */
	public static RandomLongGenerator positive() {
		return RandomLongGenerator.above(0);
	}
	
	@Override
	public Long generate() {
		return this.generate(1, 1).stream()
			.findFirst()
			.orElse(this.lowerBound);
	}
	
	@Override
	public Collection<Long> generate(final int amount, final int maxTries) {
		return this.rng.longs(amount, this.lowerBound, this.upperBound)
			.boxed()
			.collect(Collectors.toList());
	}
	
	@Override
	public long getCapacity() {
		return this.upperBound - this.lowerBound;
	}
}