/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numeric;

import io.github.thepieterdc.random.AbstractRandomGeneratorTest;
import io.github.thepieterdc.random.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.numeric.RandomDoubleGenerator.
 */
public class RandomDoubleGeneratorTest extends AbstractRandomGeneratorTest<Double> {
	@Override
	protected RandomGenerator<Double> getDefaultRandomGenerator() {
		return new RandomDoubleGenerator();
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Double> generator = new RandomDoubleGenerator();
		Assert.assertThat(generator, notNullValue());
		
		for (int i = 0; i < 100; ++i) {
			Assert.assertThat(generator.generate(), notNullValue());
		}
	}
}