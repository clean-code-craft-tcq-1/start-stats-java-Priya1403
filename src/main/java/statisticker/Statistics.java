package statisticker;

import java.util.List;

public class Statistics {

	private Float average = 0f;
	private Float min = 0f;
	private Float max = 0f;

	public Float getAverage() {
		return average;
	}

	public void setAverage(final Float average) {
		this.average = average;
	}

	public Float getMin() {
		return min;
	}

	public void setMin(final Float min) {
		this.min = min;
	}

	public Float getMax() {
		return max;
	}

	public void setMax(final Float max) {
		this.max = max;
	}

	public static Statistics getStatistics(final List<Float> numbers) {
		Statistics statistics = new Statistics();
		Float average = (float) numbers.stream().mapToDouble(number -> number).average().orElse(Float.NaN);
		Float min = (float) numbers.stream().mapToDouble(number -> number).min().orElse(Float.NaN);
		Float max = (float) numbers.stream().mapToDouble(number -> number).max().orElse(Float.NaN);
		statistics.setAverage(average);
		statistics.setMax(max);
		statistics.setMin(min);
		return statistics;

		// implement the computation of statistics here
	}

}
