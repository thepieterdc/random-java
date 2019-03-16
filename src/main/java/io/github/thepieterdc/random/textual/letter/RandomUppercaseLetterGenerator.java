/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.textual.letter;

/**
 * Generates a random uppercase letter.
 */
public class RandomUppercaseLetterGenerator extends AbstractRandomLetterGenerator {
	private static final String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * RandomUppercaseLetterGenerator constructor.
	 */
	public RandomUppercaseLetterGenerator() {
		super(ALPHA_UPPER);
	}
}
