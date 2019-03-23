/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numeric.integer;

/**
 * A random generator for integer numbers between bounds.
 */
public class BoundedRandomIntegerGenerator extends RandomIntegerGenerator {
	private final int bound;
	
	/**
	 * BoundedRandomIntegerGenerator constructor.
	 *
	 * @param bound upper bound
	 */
	BoundedRandomIntegerGenerator(final int bound) {
		this.bound = bound;
	}
	
	@Override
	public int getCapacity() {
		return this.bound;
	}
	
	@Override
	public Integer generate() {
		return this.rng.nextInt(this.bound);
	}
}