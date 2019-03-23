/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection.datasets.sports;

import io.github.thepieterdc.random.collection.Dataset;
import io.github.thepieterdc.random.collection.datasets.geo.CountriesDataset;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.random.collection.datasets.geo.CountriesDataset.
 */
public class CountriesDatasetTest {
	/**
	 * Tests the validity of one of the constants for coverage reasons.
	 */
	@Test
	public void testConstant() {
		final Dataset dataset = CountriesDataset.COUNTRIES_EUROPE;
		Assert.assertThat(dataset, notNullValue());
		Assert.assertThat(dataset.getPath().isEmpty(), is(false));
	}
}