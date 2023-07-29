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
 * Tests io.github.thepieterdc.random.numerical.RandomLongGenerator.
 */
public class RandomLongGeneratorTest extends AbstractRandomGeneratorTest<Long> {
	@Override
	protected RandomLongGenerator getDefaultRandomGenerator() {
		return RandomLongGenerator.positive();
	}

	/**
	 * Tests .above(bound).
	 */
	@Test
	public void testAbove() {
		final long bound = 200;
		final RandomGenerator<Long> generator = RandomLongGenerator.above(bound);
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
		final long bound = 200;
		final RandomGenerator<Long> generator = RandomLongGenerator.below(bound);
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
			RandomLongGenerator.between(1000, 999)
		);
	}

	/**
	 * Tests .between(lower, upper).
	 */
	@Test
	public void testBetween() {
		final long lower = 200;
		final long upper = 210;
		final RandomGenerator<Long> generator = RandomLongGenerator.between(lower, upper);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			final long generated = generator.generate();
			assertTrue(generated >= lower && generated <= upper);
		}
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Long> generator = this.getDefaultRandomGenerator();
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
		final long bound = 200;
		final RandomGenerator<Long> generator = RandomLongGenerator.positiveBelow(bound);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			final long generated = generator.generate();
			assertTrue(generated >= 0 && generated <= bound);
		}
	}
}
