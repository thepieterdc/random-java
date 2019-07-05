/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numerical.integer;

import io.github.thepieterdc.random.AbstractRandomGeneratorTest;
import io.github.thepieterdc.random.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.numeric.integer.RandomIntegerGenerator.
 */
public class RandomIntegerGeneratorTest extends AbstractRandomGeneratorTest<Integer> {
	@Override
	protected RandomGenerator<Integer> getDefaultRandomGenerator() {
		return new RandomIntegerGenerator();
	}
	
	/**
	 * Tests .below(bound).
	 */
	@Test
	public void testBelow() {
		final int bound = 200;
		final RandomGenerator<Integer> generator = RandomIntegerGenerator.below(bound);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			Assert.assertTrue(generator.generate() < bound);
		}
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Integer> generator = new RandomIntegerGenerator();
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 100; ++i) {
			Assert.assertThat(generator.generate(), notNullValue());
		}
	}
}