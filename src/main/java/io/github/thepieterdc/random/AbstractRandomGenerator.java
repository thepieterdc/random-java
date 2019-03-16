/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import java.util.Random;

/**
 * An abstract random generator.
 */
public abstract class AbstractRandomGenerator<T> implements RandomGenerator<T> {
	protected final Random rng = new Random();
}
