/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * <p>
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection.datasets.geo;

import io.github.thepieterdc.random.collection.Dataset;

/**
 * Datasets for Countries.
 */
public enum CountriesDataset {
	;
	public static final Dataset COUNTRIES_AFRICA = () -> "geo/countries/africa.txt";
	public static final Dataset COUNTRIES_ASIA = () -> "geo/countries/asia.txt";
	public static final Dataset COUNTRIES_EUROPE = () -> "geo/countries/europe.txt";
	public static final Dataset COUNTRIES_LATIN_AMERICA = () -> "geo/countries/latin_america.txt";
	public static final Dataset COUNTRIES_NORTH_AMERICA = () -> "geo/countries/north_america.txt";
	public static final Dataset COUNTRIES_OCEANIA = () -> "geo/countries/oceania.txt";
}
