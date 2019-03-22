/**
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * <p>
 * https://github.com/thepieterdc/random-java
 */
package io.github.thepieterdc.random.collection;

/**
 * A dataset to be used in random generator.
 */
@FunctionalInterface
public interface Dataset {
	/**
	 * Gets the path to the dataset.
	 *
	 * @return the dataset path
	 */
	String getPath();
}
