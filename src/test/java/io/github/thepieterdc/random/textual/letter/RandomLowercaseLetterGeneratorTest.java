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
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.textual.letter.RandomLowercaseLetterGenerator.
 */
public class RandomLowercaseLetterGeneratorTest extends AbstractRandomGeneratorTest<Character> {
	@Override
	protected RandomLowercaseLetterGenerator getDefaultRandomGenerator() {
		return new RandomLowercaseLetterGenerator();
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final RandomGenerator<Character> rng = new RandomLowercaseLetterGenerator();
		
		for(int i = 0; i < 1000; ++i) {
			final Character letter = rng.generate();
			Assert.assertThat(letter, notNullValue());
			Assert.assertThat(Character.isAlphabetic(letter), is(true));
		}
	}
}