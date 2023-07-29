/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

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
		assertNotNull(instance);
		assertTrue(instance.getCapacity() > 0);
	}

	/**
	 * Tests #generate(amount, maxtries) using a negative amount
	 */
	@Test
	public void testGenerateAmountNegative() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		assertNotNull(instance);

		assertThrows(IllegalArgumentException.class, () ->
			instance.generate(-1, 1)
		);
	}

	/**
	 * Tests #generate(amount, maxtries) using an amount value that is higher
	 * than the capacity.
	 */
	@Test
	public void testGenerateAmountTooHigh() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		assertNotNull(instance);

		final int capacity = instance.getIntegerCapacity();
		assertThrows(IllegalArgumentException.class, () ->
			instance.generate(capacity + 1, 1)
		);
	}

	/**
	 * Tests #generate(amount, maxtries).
	 */
	@Test
	public void testGenerateMultiple() {
		final RandomGenerator<T> instance = this.getDefaultRandomGenerator();
		assertNotNull(instance);

		final int capacity = instance.getIntegerCapacity();
		final int amount = Math.min(10, (int) capacity);

		final Collection<T> generated = instance.generate(amount, 1000);
		assertNotNull(generated);
		assertEquals(generated.size(), amount);
	}

	/**
	 * Tests #setRNG().
	 */
	@Test
	public void testSetRNG() {
		final long seed = RandomLongGenerator.positive().generate();

		final RandomGenerator<T> one = this.getDefaultRandomGenerator(new Random(seed));
		assertNotNull(one);

		final RandomGenerator<T> two = this.getDefaultRandomGenerator(new Random(seed));
		assertNotNull(two);

		for (int i = 0; i < 100; ++i) {
			assertEquals(one.generate(), two.generate());
		}
	}
}
