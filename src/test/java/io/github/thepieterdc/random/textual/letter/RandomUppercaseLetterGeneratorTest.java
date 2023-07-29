/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.textual.letter;

import io.github.thepieterdc.random.AbstractRandomGeneratorTest;
import io.github.thepieterdc.random.RandomGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests io.github.thepieterdc.random.textual.letter.RandomUppercaseLetterGenerator.
 */
public class RandomUppercaseLetterGeneratorTest extends AbstractRandomGeneratorTest<Character> {
	@Override
	protected RandomUppercaseLetterGenerator getDefaultRandomGenerator() {
		return new RandomUppercaseLetterGenerator();
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Character> rng = new RandomUppercaseLetterGenerator();

		for(int i = 0; i < 1000; ++i) {
			final Character letter = rng.generate();
			assertNotNull(letter);
			assertTrue(Character.isAlphabetic(letter));
		}
	}
}
