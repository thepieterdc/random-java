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
 * Tests io.github.thepieterdc.random.numerical.RandomDoubleGenerator.
 */
public class RandomDoubleGeneratorTest extends AbstractRandomGeneratorTest<Double> {
	@Override
	protected RandomGenerator<Double> getDefaultRandomGenerator() {
		return RandomDoubleGenerator.DEFAULT;
	}
	
	/**
	 * Tests .above(bound).
	 */
	@Test
	public void testAbove() {
		final double bound = 200.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.above(bound);
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
		final double bound = 200.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.below(bound);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			final double generated = generator.generate();
			Assert.assertTrue(generated <= bound);
		}
	}
	
	/**
	 * Tests .between(lower, upper) using invalid bounds.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBetweenInvalid() {
		RandomDoubleGenerator.between(1000, 999);
	}
	
	/**
	 * Tests .between(lower, upper).
	 */
	@Test
	public void testBetween() {
		final double lower = 200.0;
		final double upper = 210.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.between(lower, upper);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			final double generated = generator.generate();
			Assert.assertTrue(generated >= lower && generated <= upper);
		}
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Double> generator = this.getDefaultRandomGenerator();
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
		final double bound = 200.0;
		final RandomGenerator<Double> generator = RandomDoubleGenerator.positiveBelow(bound);
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 1000; ++i) {
			final double generated = generator.generate();
			Assert.assertTrue(generated >= 0 && generated <= bound);
		}
	}
}