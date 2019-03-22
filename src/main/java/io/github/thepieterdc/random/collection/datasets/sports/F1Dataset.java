/**
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * <p>
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection.datasets.sports;

import io.github.thepieterdc.random.collection.Dataset;

/**
 * Datasets for F1 sports data.
 */
public enum F1Dataset {
	;
	public static final Dataset TEAMS_2018 = () -> "sports/f1/teams_2018.txt";
	public static final Dataset TEAMS_2019 = () -> "sports/f1/teams_2019.txt";
}
