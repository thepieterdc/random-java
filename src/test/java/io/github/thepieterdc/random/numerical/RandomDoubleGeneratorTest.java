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
 * Tests io.github.thepieterdc.random.numerical.RandomDoubleGenerator.
 */
public class RandomDoubleGeneratorTest extends AbstractRandomGeneratorTest<Double> {
	@Override
	protected RandomDoubleGenerator getDefaultRandomGenerator() {
		return RandomDoubleGenerator.between(0.0, 1.0);
	}

	/**
	 * Tests .above(bound).
	 */
	@Test
	public void testAbove() {
		final double bound = 200.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.above(bound);
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
		final double bound = 200.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.below(bound);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			final double generated = generator.generate();
			assertTrue(generated <= bound);
		}
	}

	/**
	 * Tests .between(lower, upper) using invalid bounds.
	 */
	@Test
	public void testBetweenInvalid() {
		assertThrows(IllegalArgumentException.class, () ->
			RandomDoubleGenerator.between(1000, 999)
		);
	}

	/**
	 * Tests .between(lower, upper).
	 */
	@Test
	public void testBetween() {
		final double lower = 200.0;
		final double upper = 210.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.between(lower, upper);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			final double generated = generator.generate();
			assertTrue(generated >= lower && generated <= upper);
		}
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Double> generator = this.getDefaultRandomGenerator();
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
		final double bound = 200.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.positiveBelow(bound);
		assertNotNull(generator);

		for (int i = 0; i < 1000; ++i) {
			final double generated = generator.generate();
			assertTrue(generated >= 0 && generated <= bound);
		}
	}
}
