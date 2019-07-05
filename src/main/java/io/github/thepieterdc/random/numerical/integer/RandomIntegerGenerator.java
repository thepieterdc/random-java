/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numerical.integer;

import io.github.thepieterdc.random.AbstractRandomGenerator;
import io.github.thepieterdc.random.RandomGenerator;

/**
 * A random generator for integer numbers.
 */
public class RandomIntegerGenerator extends AbstractRandomGenerator<Integer> {
	/**
	 * Creates a bounded random integer generator instance.
	 *
	 * @param bound the upper bound
	 * @return random integer instance
	 */
	public static RandomGenerator<Integer> below(final int bound) {
		return new BoundedRandomIntegerGenerator(bound);
	}
	
	@Override
	public Integer generate() {
		return this.rng.nextInt();
	}
	
	@Override
	public int getCapacity() {
		return Integer.MAX_VALUE;
	}
}