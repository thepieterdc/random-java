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
 * A random generator for float numbers.
 */
public class RandomFloatGenerator extends AbstractRandomGenerator<Float> {
	@Override
	public Float generate() {
		return this.rng.nextFloat();
	}
	
	@Override
	public int getCapacity() {
		return Integer.MAX_VALUE;
	}
}