/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numeric;

import io.github.thepieterdc.random.AbstractRandomGenerator;

/**
 * A random generator for integer numbers.
 */
public class RandomIntegerGenerator extends AbstractRandomGenerator<Integer> {
	@Override
	public long capacity() {
		return 2 * (long) Integer.MAX_VALUE;
	}
	
	@Override
	public Integer generate() {
		return this.rng.nextInt();
	}
}