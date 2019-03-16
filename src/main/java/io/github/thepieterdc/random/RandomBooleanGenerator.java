/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

/**
 * A random generator for boolean values.
 */
public class RandomBooleanGenerator extends AbstractRandomGenerator<Boolean> {
	private final double trueProbability;
	
	/**
	 * RandomBooleanGenerator constructor.
	 *
	 * @param trueProbability the probability to generate true, between 0 and 1
	 */
	public RandomBooleanGenerator(final double trueProbability) {
		this.trueProbability = trueProbability;
	}
	
	/**
	 * RandomBooleanGenerator constructor.
	 */
	public RandomBooleanGenerator() {
		this(0.5);
	}
	
	public Boolean generate() {
		return this.rng.nextDouble() < this.trueProbability;
	}
}
