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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Tests io.github.thepieterdc.random.RandomBooleanGenerator.
 */
public class RandomBooleanGeneratorTest extends AbstractRandomGeneratorTest {
	@Override
	protected RandomGenerator getDefaultRandomGenerator() {
		return new RandomBooleanGenerator();
	}
	
	/**
	 * Tests #capacity() using only one probability.
	 */
	@Test
	public void testCapacityOnlyProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(1);
		assertThat(rng, notNullValue());
		
		assertThat(rng.getCapacity(), is(1));
	}
	
	/**
	 * Tests #capacity() using uniform probability.
	 */
	@Test
	public void testCapacityUniformProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator();
		assertThat(rng, notNullValue());
		
		assertThat(rng.getCapacity(), is(2));
	}
	
	/**
	 * Tests #capacity() using zero true probability.
	 */
	@Test
	public void testCapacityZeroProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(0);
		assertThat(rng, notNullValue());
		
		assertThat(rng.getCapacity(), is(1));
	}
	
	/**
	 * Tests #generate() using only 1 item (shortcut).
	 */
	@Test
	public void testGenerateMultipleShort() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(1);
		assertThat(rng, notNullValue());
		
		assertThat(rng.generate(1, 1).size(), is(1));
	}
	
	/**
	 * Tests #generate() using only one probability.
	 */
	@Test
	public void testOnlyProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(1);
		assertThat(rng, notNullValue());
		
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