/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random;

import io.github.thepieterdc.random.numerical.RandomIntegerGenerator;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests io.github.thepieterdc.random.RandomObjectGenerator.
 */
public class RandomObjectGeneratorTest extends AbstractRandomGeneratorTest<RandomObjectGeneratorTest.RandomObject> {
	/**
	 * Random object.
	 */
	public static class RandomObject {
		int id;

		/**
		 * RandomObject constructor.
		 *
		 * @param id the id
		 */
		public RandomObject(final int id) {
			this.id = id;
		}

		@Override
		public boolean equals(final Object other) {
			return other instanceof RandomObject && ((RandomObject) other).id == this.id;
		}

		@Override
		public int hashCode() {
			return this.id;
		}

		@Override
		public String toString() {
			return String.format("RandomObject[id=%d]", this.id);
		}
	}

	private static final RandomIntegerGenerator rig = RandomIntegerGenerator.positive();

	@Override
	protected AbstractRandomGenerator<RandomObject> getDefaultRandomGenerator(final Random random) {
		return new RandomObjectGenerator<>(
			10,
			() -> new RandomObject(random.nextInt())
		);
	}

	@Override
	protected RandomObjectGenerator<RandomObject> getDefaultRandomGenerator() {
		return new RandomObjectGenerator<>(
			10,
			() -> new RandomObject(rig.generate())
		);
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerateBounded() {
		final RandomGenerator<RandomObject> rng = this.getDefaultRandomGenerator();

		for (int i = 0; i < 1000; ++i) {
			final RandomObject obj = rng.generate();
			assertNotNull(obj);
		}
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerateUnbounded() {
		final RandomGenerator<RandomObject> rng = new RandomObjectGenerator<>(
			() -> new RandomObject(rig.generate())
		);

		for (int i = 0; i < 1000; ++i) {
			final RandomObject obj = rng.generate();
			assertNotNull(obj);
		}
	}
}
