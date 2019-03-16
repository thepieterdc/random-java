/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.textual.letter;

import io.github.thepieterdc.random.AbstractRandomGenerator;

/**
 * Generates a random lowercase letter.
 */
public class RandomLowercaseLetterGenerator extends AbstractRandomGenerator<Character> {
	private static final String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
	
	@Override
	public Character generate() {
		final int position = this.rng.nextInt(ALPHA_LOWER.length());
		return ALPHA_LOWER.charAt(position);
	}
}
