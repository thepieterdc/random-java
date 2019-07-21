/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.textual;

import io.github.thepieterdc.random.AbstractRandomGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.github.thepieterdc.random.textual.letter.RandomLowercaseLetterGenerator.ALPHA_LOWER;
import static io.github.thepieterdc.random.textual.letter.RandomUppercaseLetterGenerator.ALPHA_UPPER;

/**
 * Generates random strings containing mixed uppercase/lowercase letters.
 */
public class RandomStringGenerator extends AbstractRandomGenerator<String> {
	private static final String ALPHA = ALPHA_UPPER + ALPHA_LOWER;
	private static final int ALPHA_LENGTH = ALPHA.length();
	private final int length;
	
	/**
	 * RandomStringGenerator constructor.
	 *
	 * @param length the length of the string to generate
	 */
	public RandomStringGenerator(final int length) {
		this.length = length;
	}
	
	@Override
	public String generate() {
		return IntStream.range(0, this.length)
			.map(i -> this.rng.nextInt(ALPHA_LENGTH))
			.mapToObj(i -> String.valueOf(ALPHA.charAt(i)))
			.collect(Collectors.joining());
	}
	
	@Override
	public long getCapacity() {
		return ALPHA_LENGTH * this.length;
	}
}
