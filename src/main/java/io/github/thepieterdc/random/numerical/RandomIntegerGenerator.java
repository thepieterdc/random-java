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
 * A random generator for integer numbers.
 */
public class RandomIntegerGenerator extends AbstractRandomGenerator<Integer> {
	private final int lowerBound;
	private final int upperBound;
	
	/**
	 * RandomIntegerGenerator constructor.
	 *
	 * @param lower lower bound (inclusive)
	 * @param upper upper bound (inclusive)
	 */
	private RandomIntegerGenerator(final int lower, final int upper) {
		if (lower > upper) {
			throw new IllegalArgumentException("Upper bound must be higher than lower bound.");
		}
		this.lowerBound = lower;
		this.upperBound = upper + (upper == Integer.MAX_VALUE ? 0 : 1);
	}
	
	/**
	 * Creates a random integer generator instance that generates integers in
	 * the interval [lower, Integer.MAX_VALUE].
	 *
	 * @param lower the lower bound (inclusive)
	 * @return the random integer generator instance
	 */
	public static RandomIntegerGenerator above(final int lower) {
		return new RandomIntegerGenerator(lower, Integer.MAX_VALUE);
	}
	
	/**
	 * Creates a random integer generator instance that generates integers in
	 * the interval [Integer.MIN_VALUE, upper].
	 *
	 * @param upper the upper bound (inclusive)
	 * @return the random integer generator instance
	 */
	public static RandomIntegerGenerator below(final int upper) {
		return new RandomIntegerGenerator(Integer.MIN_VALUE, upper);
	}
	
	/**
	 * Creates a random integer generator instance that generates integers in
	 * the interval [lower, upper].
	 *
	 * @param lower the lower bound (inclusive)
	 * @param upper the upper bound (inclusive)
	 * @return the random integer generator instance
	 */
	public static RandomIntegerGenerator between(final int lower, final int upper) {
		return new RandomIntegerGenerator(lower, upper);
	}
	
	/**
	 * Creates a random integer generator instance that generates integers in
	 * the interval [0, upper].
	 *
	 * @param upper the upper bound (inclusive)
	 * @return the random integer generator instance
	 */
	public static RandomIntegerGenerator positiveBelow(final int upper) {
		return new RandomIntegerGenerator(0, upper);
	}
	
	/**
	 * Creates a random integer generator instance that generates integers in
	 * the interval [0, Integer.MAX_VALUE].
	 *
	 * @return the random integer generator instance
	 */
	public static RandomIntegerGenerator positive() {
		return RandomIntegerGenerator.above(0);
	}
	
	@Override
	public Integer generate() {
		return this.generate(1, 1).stream()
			.findFirst()
			.orElse(this.lowerBound);
	}
	
	@Override
	public Collection<Integer> generate(final int amount, final int maxTries) {
		return this.rng.ints(amount, this.lowerBound, this.upperBound)
			.boxed()
			.collect(Collectors.toList());
	}
	
	@Override
	public long getCapacity() {
		return this.upperBound - this.lowerBound;
	}
}