/**
 * <copyright>
 * 
 * Copyright (c) 2021 ETAS GmbH. All rights reserved.
 * 
 * </copyright>
 */
package statisticker;

import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class StatsChecker {

	private final float maxThreshold;
	private final IAlerter[] alerters;

	/**
	 * @param maxThreshold
	 * @param alerters
	 */
	public StatsChecker(final float maxThreshold, final IAlerter[] alerters) {
		this.alerters = alerters;
		this.maxThreshold = maxThreshold;
	}

	/**
	 * @param numbers
	 */
	public void checkAndAlert(final Float[] numbers) {
		List<Float> numberList = Arrays.asList(numbers);
		Float max = (float) numberList.stream().mapToDouble(number -> number).max().orElse(Float.NaN);
		if (max > maxThreshold) {
			for (IAlerter alerter : alerters) {
				if (alerter instanceof EmailAlert) {
					alerter.emailSent = true;
				}
				if (alerter instanceof IAlerter) {
					alerter.ledGlows = true;
				}

			}

			// alert.emailSent = true;
			// alert2.ledGlows = true;

		}

	}

}
