/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection.datasets.sports.soccer;

import io.github.thepieterdc.random.collection.Dataset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests io.github.thepieterdc.random.collection.datasets.sports.soccer.BelgianSoccerDataset
 */
public class BelgianSoccerDatasetTest {
	/**
	 * Tests the validity of one of the constants for coverage reasons.
	 */
	@Test
	public void testConstant() {
		final Dataset dataset = BelgianSoccerDataset.PRO_LEAGUE_TEAMS_2018_2019;
		assertNotNull(dataset);

		assertFalse(dataset.getPath().isEmpty());
	}
}
