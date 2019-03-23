/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.AbstractRandomGenerator.
 */
public abstract class AbstractRandomGeneratorTest<T> {
	/**
	 * Gets a default random generator instance to test things on.
	 *
	 * @return random generator instance
	 */
	abstract protected RandomGenerator<T> getDefaultRandomGenerator();
	
	/**
	 * Tests #getCapacity().
	 */
	@Test
	public void testGetCapacity() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		Assert.assertThat(instance, notNullValue());
		Assert.assertTrue(instance.getCapacity() > 0);
	}
	
	/**
	 * Tests #generate(amount, maxtries) using a negative amount
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateAmountNegative() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		Assert.assertThat(instance, notNullValue());
		
		instance.generate(-1, 1);
	}
	
	/**
	 * Tests #generate(amount, maxtries) using an amount value that is higher
	 * than the capacity.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateAmountTooHigh() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		Assert.assertThat(instance, notNullValue());
		
		final long capacity = instance.getCapacity();
		instance.generate((int) capacity + 1, 1);
	}
	
	/**
	 * Tests #generate(amount, maxtries).
	 */
	@Test
	public void testGenerateMultiple() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		Assert.assertThat(instance, notNullValue());
		
		final long capacity = instance.getCapacity();
		final int amount = Math.min(10, (int) capacity);
		
		final Collection<T> generated = instance.generate(amount, 1000);
		Assert.assertThat(generated, notNullValue());
		Assert.assertThat(generated.size(), is(amount));
	}
}