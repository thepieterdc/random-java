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
 * Generates a random uppercase letter.
 */
public class RandomUppercaseLetterGenerator extends AbstractRandomGenerator<Character> {
	private static final String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	@Override
	public Character generate() {
		final int position = this.rng.nextInt(ALPHA_UPPER.length());
		return ALPHA_UPPER.charAt(position);
	}
}
