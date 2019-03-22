/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection;

import io.github.thepieterdc.random.AbstractRandomGenerator;
import io.github.thepieterdc.random.RandomGenerator;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generates random values from a collection.
 */
public class RandomCollectionGenerator extends AbstractRandomGenerator<String> {
	private final List<String> values;
	
	/**
	 * RandomCollectionGenerator constructor.
	 *
	 * @param values the input data
	 */
	public RandomCollectionGenerator(final Collection<String> values) {
		if (values.isEmpty()) throw new IllegalArgumentException("Collection may not be empty.");
		this.values = new ArrayList<>(values);
	}
	
	@Override
	public String generate() {
		final int idx = this.rng.nextInt(this.values.size());
		return this.values.get(idx);
	}
	
	/**
	 * Constructs a new RandomCollectionGenerator from a given dataset.
	 *
	 * @param dataset the input dataset
	 * @return the random generator instance
	 */
	public static RandomGenerator<String> of(final Dataset dataset) {
		final Path path = Optional.ofNullable(RandomCollectionGenerator.class.getClassLoader().getResource(dataset.getPath()))
			.map(URL::getFile)
			.map(Paths::get)
			.orElseThrow(() ->
				new RuntimeException(String.format("The required resource %s could not be found.", dataset.getPath()))
			);
		
		return of(path);
	}
	
	/**
	 * Constructs a new RandomCollectionGenerator from a given file.
	 *
	 * @param file the input file
	 * @return the random generator instance
	 */
	public static RandomGenerator<String> of(final Path file) {
		try (Stream<String> lines = Files.lines(file)) {
			return new RandomCollectionGenerator(lines.collect(Collectors.toList()));
		} catch (final IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
}
