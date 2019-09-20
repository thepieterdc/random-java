/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.AbstractRandomGenerator.
 */
public abstract class AbstractRandomGeneratorTest<T> {
	/**
	 * Gets a default seeded random generator instance to test things on.
	 *
	 * @param random the random seed
	 * @return random generator instance
	 */
	protected AbstractRandomGenerator<T> getDefaultRandomGenerator(final Random random) {
		final AbstractRandomGenerator<T> ret = this.getDefaultRandomGenerator();
		ret.setRNG(random);
		return ret;
	}
	
	/**
	 * Gets a default random generator instance to test things on.
	 *
	 * @return random generator instance
	 */
	abstract protected AbstractRandomGenerator<T> getDefaultRandomGenerator();
	
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
		
		final int capacity = instance.getIntegerCapacity();
		instance.generate(capacity + 1, 1);
	}
	
	/**
	 * Tests #generate(amount, maxtries).
	 */
	@Test
	public void testGenerateMultiple() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		Assert.assertThat(instance, notNullValue());
		
		final int capacity = instance.getIntegerCapacity();
		final int amount = Math.min(10, (int) capacity);
		
		final Collection<T> generated = instance.generate(amount, 1000);
		Assert.assertThat(generated, notNullValue());
		Assert.assertThat(generated.size(), is(amount));
	}
	
	/**
	 * Tests #setRNG().
	 */
	@Test
	public void testSetRNG() {
		final long seed = RandomLongGenerator.positive().generate();
		
		final RandomGenerator<T> one = this.getDefaultRandomGenerator(new Random(seed));
		Assert.assertNotNull(one);
		
		final RandomGenerator<T> two = this.getDefaultRandomGenerator(new Random(seed));
		Assert.assertNotNull(two);
		
		for (int i = 0; i < 100; ++i) {
			Assert.assertEquals(one.generate(), two.generate());
		}
	}
}