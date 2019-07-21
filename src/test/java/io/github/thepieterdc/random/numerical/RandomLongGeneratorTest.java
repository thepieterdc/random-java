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
 * Tests io.github.thepieterdc.random.numerical.RandomLongGenerator.
 */
public class RandomLongGeneratorTest extends AbstractRandomGeneratorTest<Long> {
	@Override
	protected RandomGenerator<Long> getDefaultRandomGenerator() {
		return RandomLongGenerator.POSITIVE;
	}
	
	/**
	 * Tests .above(bound).
	 */
	@Test
	public void testAbove() {
		final long bound = 200;
		final RandomGenerator<Long> generator = RandomLongGenerator.above(bound);
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
		final long bound = 200;
		final RandomGenerator<Long> generator = RandomLongGenerator.below(bound);
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
		RandomLongGenerator.between(1000, 999);
	}
	
	/**
	 * Tests .between(lower, upper).
	 */
	@Test
	public void testBetween() {
		final long lower = 200;
		final long upper = 210;
		final RandomGenerator<Long> generator = RandomLongGenerator.between(lower, upper);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			final long generated = generator.generate();
			Assert.assertTrue(generated >= lower && generated <= upper);
		}
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Long> generator = this.getDefaultRandomGenerator();
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
		final long bound = 200;
		final RandomGenerator<Long> generator = RandomLongGenerator.positiveBelow(bound);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			final long generated = generator.generate();
			Assert.assertTrue(generated >= 0 && generated <= bound);
		}
	}
}