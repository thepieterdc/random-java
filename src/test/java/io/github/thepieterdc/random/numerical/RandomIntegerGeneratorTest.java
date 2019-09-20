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
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

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
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			Assert.assertTrue(generator.generate() >= bound);
		}
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
			Assert.assertTrue(generator.generate() <= bound);
		}
	}
	
	/**
	 * Tests .between(lower, upper) using invalid bounds.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBetweenInvalid() {
		RandomIntegerGenerator.between(1000, 999);
	}
	
	/**
	 * Tests .between(lower, upper).
	 */
	@Test
	public void testBetween() {
		final int lower = 200;
		final int upper = 210;
		final RandomGenerator<Integer> generator = RandomIntegerGenerator.between(lower, upper);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			final int generated = generator.generate();
			Assert.assertTrue(generated >= lower && generated <= upper);
		}
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Integer> generator = this.getDefaultRandomGenerator();
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 100; ++i) {
			Assert.assertThat(generator.generate(), notNullValue());
		}
	}
	
	/**
	 * Tests .positiveBelow(bound).
	 */
	@Test
	public void testPositiveBelow() {
		final int bound = 200;
		final RandomGenerator<Integer> generator = RandomIntegerGenerator.positiveBelow(bound);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			final int generated = generator.generate();
			Assert.assertTrue(generated >= 0 && generated <= bound);
		}
	}
}