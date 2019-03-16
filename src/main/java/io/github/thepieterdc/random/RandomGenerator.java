/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import java.util.Collection;

/**
 * A generator for random values.
 *
 * @param <T> type class of the generated value
 */
public interface RandomGenerator<T> {
	/**
	 * Generates a random value.
	 *
	 * @return the random value
	 */
	T generate();
}
