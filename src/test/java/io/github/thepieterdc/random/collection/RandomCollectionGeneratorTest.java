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
		final RandomCollectionGenerator<String> generator = new RandomCollectionGenerator<>(Collections.singleton("test"));
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
		final RandomCollectionGenerator<String> generator = new RandomCollectionGenerator<>(Collections.singleton("test"));
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
	 * Tests the constructor using an empty collection.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyCollection() {
		new RandomCollectionGenerator<>(Collections.emptySet());
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final Collection<String> data = Arrays.asList(
			"Test1", "Test2", "Test3", "Test4"
		);
		
		final RandomGenerator<String> generator = new RandomCollectionGenerator<>(data);
		
		for (int i = 0; i < 100; ++i) {
			Assert.assertThat(data, hasItem(generator.generate()));
		}
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