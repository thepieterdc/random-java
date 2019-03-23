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
 * Tests io.github.thepieterdc.random.numeric.RandomIntegerGenerator.
 */
public class RandomIntegerGeneratorTest extends AbstractRandomGeneratorTest<Integer> {
	@Override
	protected RandomGenerator<Integer> getDefaultRandomGenerator() {
		return new RandomIntegerGenerator();
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