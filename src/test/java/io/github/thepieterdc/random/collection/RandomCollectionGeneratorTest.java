/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection;

import io.github.thepieterdc.random.RandomGenerator;
import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.random.collection.RandomCollectionGeneratorTest.
 */
public class RandomCollectionGeneratorTest {
	/**
	 * Tests #add().
	 */
	@Test
	public void testAdd() {
		final RandomCollectionGenerator<String> generator = RandomCollectionGenerator.of(Collections.singleton("test"));
		assertNotNull(generator);

		int test2counts = 0;
		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			assertNotNull(generated);
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
		}

		assertEquals(test2counts, 0);

		generator.add("test2");

		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			assertNotNull(generated);
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
		}

		assertNotEquals(0, test2counts);
	}

	/**
	 * Tests #addCollection().
	 */
	@Test
	public void testAddCollection() {
		final RandomCollectionGenerator<String> generator = RandomCollectionGenerator.of(Collections.singleton("test"));
		assertNotNull(generator);

		int test2counts = 0;
		int test3counts = 0;
		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			assertNotNull(generated);
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
			test3counts += generated.equalsIgnoreCase("test3") ? 1 : 0;
		}

		assertEquals(test2counts, 0);
		assertEquals(test3counts, 0);

		generator.addAll(Arrays.asList("test2", "test3"));

		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			assertNotNull(generated);
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
			test3counts += generated.equalsIgnoreCase("test3") ? 1 : 0;
		}

		assertNotEquals(0, test2counts);
		assertNotEquals(0, test3counts);
	}

	/**
	 * Tests #capacity().
	 */
	@Test
	public void testCapacity() {
		final long amount = 10;
		final Collection<Long> capacities = LongStream.range(0, amount).boxed().collect(Collectors.toSet());
		final RandomGenerator<Long> rng = RandomCollectionGenerator.of(capacities);
		assertNotNull(rng);
		assertEquals(rng.getCapacity(), amount);
	}

	/**
	 * Tests the constructor using an empty collection.
	 */
	@Test
	public void testEmptyCollection() {
		assertThrows(IllegalArgumentException.class, () ->
			RandomCollectionGenerator.of(Collections.emptySet())
		);
	}

	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final Collection<String> data = Arrays.asList(
			"Test1", "Test2", "Test3", "Test4"
		);

		final RandomGenerator<String> generator = RandomCollectionGenerator.of(data);

		for (int i = 0; i < 100; ++i) {
			assertTrue(data.contains(generator.generate()));
		}
	}

	/**
	 * Tests #generate(amount, maxtries) using a negative amount
	 */
	@Test
	public void testGenerateAmountNegative() {
		final RandomGenerator<String> instance = RandomCollectionGenerator.of(Collections.singleton("test"));
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
		final RandomGenerator<String> instance = RandomCollectionGenerator.of(Collections.singleton("test"));
		assertNotNull(instance);

		final long capacity = instance.getCapacity();
		assertThrows(IllegalArgumentException.class, () ->
			instance.generate((int) capacity + 1, 1)
		);
	}

	/**
	 * Tests #generate(amount, maxtries).
	 */
	@Test
	public void testGenerateMultiple() {
		final Collection<String> data = Arrays.asList("a", "b", "c");
		assertNotNull(data);

		final RandomGenerator<String> instance = RandomCollectionGenerator.of(data);
		assertNotNull(instance);

		final Collection<String> generated = instance.generate(data.size(), 1000);
		assertNotNull(generated);
		assertEquals(generated.size(), data.size());
	}

	/**
	 * Tests .of(Dataset) using an existing dataset.
	 */
	@Test
	public void testOfDataset() {
		final Dataset existing = () -> "letters.txt";
		assertNotNull(RandomCollectionGenerator.of(existing));
	}

	/**
	 * Tests .of() using a non-existing dataset.
	 */
	@Test
	public void testOfNonExistingDataset() {
		final Dataset nonExisting = () -> "/non/existing";
		assertThrows(RuntimeException.class, () ->
			RandomCollectionGenerator.of(nonExisting)
		);
	}

	/**
	 * Tests .of(Path) using an invalid file.
	 */
	@Test
	public void testOfPathInvalid() {
		assertThrows(RuntimeException.class, () ->
			RandomCollectionGenerator.of(Paths.get("/non/existing"))
		);
	}

	/**
	 * Tests #setRNG().
	 */
	@Test
	public void testSetRNG() {
		final long seed = RandomLongGenerator.positive().generate();

		final RandomCollectionGenerator<Integer> one = RandomCollectionGenerator.of(Arrays.asList(
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		)).setRNG(new Random(seed));
		assertNotNull(one);

		final RandomCollectionGenerator<Integer> two = RandomCollectionGenerator.of(Arrays.asList(
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		)).setRNG(new Random(seed));
		assertNotNull(two);

		for (int i = 0; i < 100; ++i) {
			assertEquals(one.generate(), two.generate());
		}
	}
}
