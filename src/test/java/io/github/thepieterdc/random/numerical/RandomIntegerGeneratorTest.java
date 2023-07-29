/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numerical;

import io.github.thepieterdc.random.AbstractRandomGeneratorTest;
import io.github.thepieterdc.random.RandomGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.random.numerical.RandomIntegerGenerator.
 */
public class RandomIntegerGeneratorTest extends AbstractRandomGeneratorTest<Integer> {
	@Override
	protected RandomIntegerGenerator getDefaultRandomGenerator() {
		return RandomIntegerGenerator.positive();
	}

	/**
	 * Tests .above(bound).
	 */
	@Test
	public void testAbove() {
		final int bound = 200;
		final RandomGenerator<Integer> generator = RandomIntegerGenerator.above(bound);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			assertTrue(generator.generate() >= bound);
		}
	}

	/**
	 * Tests .below(bound).
	 */
	@Test
	public void testBelow() {
		final int bound = 200;
		final RandomGenerator<Integer> generator = RandomIntegerGenerator.below(bound);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			assertTrue(generator.generate() <= bound);
		}
	}

	/**
	 * Tests .between(lower, upper) using invalid bounds.
	 */
	@Test
	public void testBetweenInvalid() {
		assertThrows(IllegalArgumentException.class, () ->
			RandomIntegerGenerator.between(1000, 999)
		);
	}

	/**
	 * Tests .between(lower, upper).
	 */
	@Test
	public void testBetween() {
		final int lower = 200;
		final int upper = 210;
		final RandomGenerator<Integer> generator = RandomIntegerGenerator.between(lower, upper);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			final int generated = generator.generate();
			assertTrue(generated >= lower && generated <= upper);
		}
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Integer> generator = this.getDefaultRandomGenerator();
		assertNotNull(generator);

		for (int i = 0; i < 100; ++i) {
			assertNotNull(generator.generate());
		}
	}

	/**
	 * Tests .positiveBelow(bound).
	 */
	@Test
	public void testPositiveBelow() {
		final int bound = 200;
		final RandomGenerator<Integer> generator = RandomIntegerGenerator.positiveBelow(bound);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			final int generated = generator.generate();
			assertTrue(generated >= 0 && generated <= bound);
		}
	}
}
