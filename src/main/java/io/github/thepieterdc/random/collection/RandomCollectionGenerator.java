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
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generates random values from a collection.
 *
 * @param <T> type class of the random value
 */
public class RandomCollectionGenerator<T> extends AbstractRandomGenerator<T> {
	private final List<T> values;
	
	/**
	 * RandomCollectionGenerator constructor.
	 *
	 * @param values the input data
	 */
	public RandomCollectionGenerator(final Collection<T> values) {
		if (values.isEmpty()) throw new IllegalArgumentException("Collection may not be empty.");
		this.values = new ArrayList<>(values);
	}
	
	/**
	 * Adds the given option to the value set. If the option already exists, it
	 * is not added. For bulk operations, please use #addAll() for performance
	 * reasons.
	 *
	 * @param option the option to add
	 */
	public void add(final T option) {
		if (!this.values.contains(option)) {
			this.values.add(option);
		}
	}
	
	/**
	 * Adds the given options to the value set. Options that already exist will
	 * be ignored.
	 *
	 * @param options the options to add
	 */
	public void addAll(final Collection<T> options) {
		final Collection<T> ret = Stream.of(this.values, options)
			.flatMap(Collection::stream)
			.distinct()
			.collect(Collectors.toList());
		
		this.values.clear();
		this.values.addAll(ret);
	}
	
	@Override
	public T generate() {
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
			return new RandomCollectionGenerator<>(lines.collect(Collectors.toList()));
		} catch (final IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
}
