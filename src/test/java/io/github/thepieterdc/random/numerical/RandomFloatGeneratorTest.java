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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests io.github.thepieterdc.random.numeric.RandomFloatGenerator.
 */
public class RandomFloatGeneratorTest extends AbstractRandomGeneratorTest<Float> {
	@Override
	protected RandomFloatGenerator getDefaultRandomGenerator() {
		return new RandomFloatGenerator();
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Float> generator = new RandomFloatGenerator();
		assertNotNull(generator);

		for (int i = 0; i < 100; ++i) {
			assertNotNull(generator.generate());
		}
	}
}
