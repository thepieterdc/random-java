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
 * Tests io.github.thepieterdc.random.numeric.RandomLongGenerator.
 */
public class RandomLongGeneratorTest extends AbstractRandomGeneratorTest<Long> {
	@Override
	protected RandomGenerator<Long> getDefaultRandomGenerator() {
		return RandomLongGenerator.POSITIVE;
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
}