/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection;

import io.github.thepieterdc.random.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.*;

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
		Assert.assertThat(generator, notNullValue());
		
		int test2counts = 0;
		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			Assert.assertThat(generated, notNullValue());
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
		}
		
		Assert.assertThat(test2counts, is(0));
		
		generator.add("test2");
		
		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			Assert.assertThat(generated, notNullValue());
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
		}
		
		Assert.assertThat(test2counts == 0, is(false));
	}
	
	/**
	 * Tests #addCollection().
	 */
	@Test
	public void testAddCollection() {
		final RandomCollectionGenerator<String> generator = RandomCollectionGenerator.of(Collections.singleton("test"));
		Assert.assertThat(generator, notNullValue());
		
		int test2counts = 0;
		int test3counts = 0;
		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			Assert.assertThat(generated, notNullValue());
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
			test3counts += generated.equalsIgnoreCase("test3") ? 1 : 0;
		}
		
		Assert.assertThat(test2counts, is(0));
		Assert.assertThat(test3counts, is(0));
		
		generator.addAll(Arrays.asList("test2", "test3"));
		
		for (int i = 0; i < 100; ++i) {
			final String generated = generator.generate();
			Assert.assertThat(generated, notNullValue());
			test2counts += generated.equalsIgnoreCase("test2") ? 1 : 0;
			test3counts += generated.equalsIgnoreCase("test3") ? 1 : 0;
		}
		
		Assert.assertThat(test2counts == 0, is(false));
		Assert.assertThat(test3counts == 0, is(false));
	}
	
	/**
	 * Tests #capacity().
	 */
	@Test
	public void testCapacity() {
		final long amount = 10;
		final Collection<Long> capacities = LongStream.range(0, amount).boxed().collect(Collectors.toSet());
		final RandomGenerator<Long> rng = RandomCollectionGenerator.of(capacities);
		Assert.assertThat(rng, notNullValue());
		Assert.assertThat(rng.getCapacity(), is(amount));
	}
	
	/**
	 * Tests the constructor using an empty collection.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyCollection() {
		RandomCollectionGenerator.of(Collections.emptySet());
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
			Assert.assertThat(data, hasItem(generator.generate()));
		}
	}
	
	/**
	 * Tests #generate(amount, maxtries) using a negative amount
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateAmountNegative() {
		final RandomGenerator<String> instance = RandomCollectionGenerator.of(Collections.singleton("test"));
		Assert.assertThat(instance, notNullValue());
		
		instance.generate(-1, 1);
	}
	
	/**
	 * Tests #generate(amount, maxtries) using an amount value that is higher
	 * than the capacity.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateAmountTooHigh() {
		final RandomGenerator<String> instance = RandomCollectionGenerator.of(Collections.singleton("test"));
		Assert.assertThat(instance, notNullValue());
		
		final long capacity = instance.getCapacity();
		instance.generate((int) capacity + 1, 1);
	}
	
	/**
	 * Tests #generate(amount, maxtries).
	 */
	@Test
	public void testGenerateMultiple() {
		final Collection<String> data = Arrays.asList("a", "b", "c");
		Assert.assertThat(data, notNullValue());
		
		final RandomGenerator<String> instance = RandomCollectionGenerator.of(data);
		Assert.assertThat(instance, notNullValue());
		
		final Collection<String> generated = instance.generate(data.size(), 1000);
		Assert.assertThat(generated, notNullValue());
		Assert.assertThat(generated.size(), is(data.size()));
	}
	
	/**
	 * Tests .of(Dataset) using an existing dataset.
	 */
	@Test
	public void testOfDataset() {
		final Dataset existing = () -> "letters.txt";
		Assert.assertThat(RandomCollectionGenerator.of(existing), notNullValue());
	}
	
	/**
	 * Tests .of() using a non-existing dataset.
	 */
	@Test(expected = RuntimeException.class)
	public void testOfNonExistingDataset() {
		final Dataset nonExisting = () -> "/non/existing";
		RandomCollectionGenerator.of(nonExisting);
	}
	
	/**
	 * Tests .of(Path) using an invalid file.
	 */
	@Test(expected = RuntimeException.class)
	public void testOfPathInvalid() {
		RandomCollectionGenerator.of(Paths.get("/non/existing"));
	}
}