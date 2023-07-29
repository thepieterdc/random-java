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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests io.github.thepieterdc.random.numeric.RandomPrimeGenerator.
 */
public class RandomPrimeGeneratorTest extends AbstractRandomGeneratorTest<Integer> {
	@Override
	protected RandomPrimeGenerator getDefaultRandomGenerator() {
		return new RandomPrimeGenerator();
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Integer> generator = new RandomPrimeGenerator();
		for (int i = 2; i <= 200; ++i) {
			final int number = generator.generate();
			assertTrue(number > 1);
			if (number != i) {
				assertNotEquals(number % i, 0);
			}
		}
	}
}
