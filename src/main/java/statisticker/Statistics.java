package statisticker;

import java.util.List;

public class Statistics {

	public static Stats getStatistics(final List<Float> numbers) {
		Stats statistics = new Stats();
		Float average = (float) numbers.stream().mapToDouble(number -> number).average().orElse(Float.NaN);
		Float min = (float) numbers.stream().mapToDouble(number -> number).min().orElse(Float.NaN);
		Float max = (float) numbers.stream().mapToDouble(number -> number).max().orElse(Float.NaN);
		statistics.setAverage(average);
		statistics.setMax(max);
		statistics.setMin(min);
		return statistics;

	}

}
