/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numeric;

import io.github.thepieterdc.random.RandomGenerator;
import org.junit.Test;

/**
 * Tests io.github.thepieterdc.random.numeric.RandomFloatGenerator.
 */
public class RandomFloatGeneratorTest {
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Float> generator = new RandomFloatGenerator();
		for (int i = 0; i < 100; ++i) {
			generator.generate();
		}
	}
}