/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.temporal;

import io.github.thepieterdc.random.AbstractRandomGenerator;

import java.time.LocalTime;

/**
 * Generates a random time of day.
 */
public class RandomTimeGenerator extends AbstractRandomGenerator<LocalTime> {
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	private static final int SECONDS_PER_MINUTE = 60;
	
	@Override
	public LocalTime generate() {
		final int hours = this.rng.nextInt(HOURS_PER_DAY);
		final int minutes = this.rng.nextInt(MINUTES_PER_HOUR);
		final int seconds = this.rng.nextInt(SECONDS_PER_MINUTE);
		return LocalTime.of(hours, minutes, seconds);
	}
}
