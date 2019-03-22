/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numeric;

import io.github.thepieterdc.random.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 * Tests io.github.thepieterdc.random.numeric.RandomPrimeGenerator.
 */
public class RandomPrimeGeneratorTest {
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Integer> generator = new RandomPrimeGenerator();
		for (int i = 2; i <= 200; ++i) {
			final int number = generator.generate();
			Assert.assertTrue(number > 1);
			if (number != i) {
				Assert.assertThat(number % i, not(is(0)));
			}
		}
	}
}