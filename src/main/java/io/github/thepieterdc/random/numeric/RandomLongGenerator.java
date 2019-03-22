/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.numeric;

import io.github.thepieterdc.random.AbstractRandomGenerator;

/**
 * A random generator for long numbers.
 */
public class RandomLongGenerator extends AbstractRandomGenerator<Long> {
	@Override
	public Long generate() {
		return this.rng.nextLong();
	}
}