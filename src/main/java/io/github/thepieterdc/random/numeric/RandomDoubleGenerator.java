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
 * A random generator for double numbers.
 */
public class RandomDoubleGenerator extends AbstractRandomGenerator<Double> {
	@Override
	public Double generate() {
		return this.rng.nextDouble();
	}
	
	@Override
	public int getCapacity() {
		return Integer.MAX_VALUE;
	}
}