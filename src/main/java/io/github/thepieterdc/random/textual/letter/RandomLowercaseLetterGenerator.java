/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.textual.letter;

/**
 * Generates a random lowercase letter.
 */
public class RandomLowercaseLetterGenerator extends AbstractRandomLetterGenerator {
	private static final String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * RandomLowercaseLetterGenerator constructor.
	 */
	public RandomLowercaseLetterGenerator() {
		super(ALPHA_LOWER);
	}
}
