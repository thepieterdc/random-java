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
 * Generates a random letter from a string.
 */
abstract class AbstractRandomLetterGenerator extends AbstractRandomGenerator<Character> {
	private final String letters;
	
	/**
	 * AbstractRandomLetterGenerator constructor.
	 *
	 * @param letters the letters to pick from
	 */
	AbstractRandomLetterGenerator(final String letters) {
		this.letters = letters;
	}
	
	@Override
	public Character generate() {
		final int position = this.rng.nextInt(this.letters.length());
		return this.letters.charAt(position);
	}
}
