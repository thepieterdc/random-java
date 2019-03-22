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

import static org.hamcrest.CoreMatchers.hasItem;

/**
 * Tests io.github.thepieterdc.random.collection.RandomCollectionGeneratorTest.
 */
public class RandomCollectionGeneratorTest {
	/**
	 * Tests the constructor using an empty collection.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyCollection() {
		new RandomCollectionGenerator(Collections.emptySet());
	}
	
	/**
	 * Tests #generate().
	 */
	@Test
	public void testGenerate() {
		final Collection<String> data = Arrays.asList(
			"Test1", "Test2", "Test3", "Test4"
		);
		
		final RandomGenerator<String> generator = new RandomCollectionGenerator(data);
		
		for(int i = 0; i < 100; ++i) {
			Assert.assertThat(data, hasItem(generator.generate()));
		}
	}
	
	/**
	 * Tests .of(Dataset) using an existing dataset.
	 */
	@Test
	public void testOfDataset() {
		final Dataset existing = () -> "letters.txt";
		RandomCollectionGenerator.of(existing);
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