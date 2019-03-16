/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Tests io.github.thepieterdc.random.RandomBooleanGenerator.
 */
public class RandomBooleanGeneratorTest {
	/**
	 * Tests #generate() using only one probability.
	 */
	@Test
	public void testOnlyProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(1);
		
		int amountTrue = 0;
		for (int i = 0; i < 1000; ++i) {
			amountTrue += rng.generate() ? 1 : 0;
		}
		
		assertThat(amountTrue, is(1000));
	}
	
	/**
	 * Tests #generate() using an uniform probability (50%).
	 */
	@Test
	public void testUniformProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator();
		
		int amountTrue = 0;
		for (int i = 0; i < 1000; ++i) {
			amountTrue += rng.generate() ? 1 : 0;
		}
		
		assertTrue(Math.abs(500 - amountTrue) < 100);
	}
	
	/**
	 * Tests #generate() using zero probability.
	 */
	@Test
	public void testZeroProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(0);
		
		int amountTrue = 0;
		for (int i = 0; i < 1000; ++i) {
			amountTrue += rng.generate() ? 1 : 0;
		}
		
		assertThat(amountTrue, is(0));
	}
}