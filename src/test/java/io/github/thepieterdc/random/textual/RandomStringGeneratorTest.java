/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.textual;

import io.github.thepieterdc.random.AbstractRandomGeneratorTest;
import io.github.thepieterdc.random.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.textual.RandomStringGenerator.
 */
public class RandomStringGeneratorTest extends AbstractRandomGeneratorTest<String> {
	@Override
	protected RandomGenerator<String> getDefaultRandomGenerator() {
		return new RandomStringGenerator(4);
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final int length = 20;
		final RandomGenerator<String> rng = new RandomStringGenerator(length);
		
		for(int i = 0; i < 1000; ++i) {
			final String string = rng.generate();
			Assert.assertThat(string, notNullValue());
			Assert.assertThat(string.length(), is(length));
		}
	}
}