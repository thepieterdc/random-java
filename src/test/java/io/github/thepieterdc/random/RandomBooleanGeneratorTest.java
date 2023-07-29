/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.random.RandomBooleanGenerator.
 */
public class RandomBooleanGeneratorTest extends AbstractRandomGeneratorTest<Boolean> {
	@Override
	protected RandomBooleanGenerator getDefaultRandomGenerator() {
		return new RandomBooleanGenerator();
	}

	/**
	 * Tests #capacity() using only one probability.
	 */
	@Test
	public void testCapacityOnlyProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(1);
		assertNotNull(rng);

		assertEquals(rng.getCapacity(), 1L);
	}

	/**
	 * Tests #capacity() using uniform probability.
	 */
	@Test
	public void testCapacityUniformProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator();
		assertNotNull(rng);

		assertEquals(rng.getCapacity(), 2L);
	}

	/**
	 * Tests #capacity() using zero true probability.
	 */
	@Test
	public void testCapacityZeroProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(0);
		assertNotNull(rng);

		assertEquals(rng.getCapacity(), 1L);
	}

	/**
	 * Tests #generate() using only 1 item (shortcut).
	 */
	@Test
	public void testGenerateMultipleShort() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(1);
		assertNotNull(rng);

		assertEquals(rng.generate(1, 1).size(), 1);
	}

	/**
	 * Tests #generate() using only one probability.
	 */
	@Test
	public void testOnlyProbability() {
		final RandomGenerator<Boolean> rng = new RandomBooleanGenerator(1);
		assertNotNull(rng);

		int amountTrue = 0;
		for (int i = 0; i < 1000; ++i) {
			amountTrue += rng.generate() ? 1 : 0;
		}

		assertEquals(amountTrue, 1000);
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

		assertEquals(amountTrue, 0);
	}
}
