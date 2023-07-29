/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection.datasets.sports;

import io.github.thepieterdc.random.collection.Dataset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests io.github.thepieterdc.random.collection.datasets.sports.F1Dataset
 */
public class F1DatasetTest {
	/**
	 * Tests the validity of one of the constants for coverage reasons.
	 */
	@Test
	public void testConstant() {
		final Dataset dataset = F1Dataset.TEAMS_2018;
		assertNotNull(dataset);

		assertFalse(dataset.getPath().isEmpty());
	}
}
