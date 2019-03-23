/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.temporal;

import io.github.thepieterdc.random.AbstractRandomGeneratorTest;
import io.github.thepieterdc.random.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.temporal.RandomTimeGenerator.
 */
public class RandomTimeGeneratorTest extends AbstractRandomGeneratorTest<LocalTime> {
	@Override
	protected RandomGenerator<LocalTime> getDefaultRandomGenerator() {
		return new RandomTimeGenerator();
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<LocalTime> rng = new RandomTimeGenerator();
		
		for(int i = 0; i < 1000; ++i) {
			LocalTime timestamp = rng.generate();
			Assert.assertThat(timestamp, notNullValue());
		}
	}
}