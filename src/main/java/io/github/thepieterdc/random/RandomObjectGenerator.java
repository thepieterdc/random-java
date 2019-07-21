/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import java.util.function.Supplier;

/**
 * A random generator for objects.
 */
public class RandomObjectGenerator<T> extends AbstractRandomGenerator<T> {
	private final long capacity;
	private final Supplier<T> generator;
	
	/**
	 * RandomObjectGenerator constructor. A capacity of Long.MAX_VALUE is
	 * assumed.
	 *
	 * @param generator the generator function
	 */
	public RandomObjectGenerator(final Supplier<T> generator) {
		this(Long.MAX_VALUE, generator);
	}
	
	/**
	 * RandomObjectGenerator constructor.
	 *
	 * @param capacity  the maximum amount of unique objects that can be
	 *                  generated
	 * @param generator the generator function
	 */
	public RandomObjectGenerator(final long capacity, final Supplier<T> generator) {
		this.capacity = capacity;
		this.generator = generator;
	}
	
	public T generate() {
		return this.generator.get();
	}
	
	@Override
	public long getCapacity() {
		return this.capacity;
	}
}
