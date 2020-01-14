package com.miguelbraga.fevercalculator;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class OralReading implements TemperatureInterface {
	
	private static final Map<AgeRange, Double> celsiusThresholdsOral;
	
	static {
		Map<AgeRange, Double> minTempFeverCelsiusOral = new TreeMap<AgeRange, Double>();
		
		minTempFeverCelsiusOral.put(AgeRange.YOUNGER_THAN_3, 37.5);
		minTempFeverCelsiusOral.put(AgeRange.BETWEEN_3_AND_11, 37.5);
		minTempFeverCelsiusOral.put(AgeRange.BETWEEN_11_AND_65, 37.6);
		minTempFeverCelsiusOral.put(AgeRange.OVER_65, 36.9);
		
		celsiusThresholdsOral = Collections.unmodifiableMap(minTempFeverCelsiusOral);
	}

	public ReadingType getReadingType() {
		return ReadingType.ORAL;
	}

	public boolean hasFever(AgeRange ageRange, double reading) {
		boolean feverIndicator = false;
		
		for (Map.Entry<AgeRange, Double> entry: celsiusThresholdsOral.entrySet()) {
			if (ageRange == entry.getKey() && reading > entry.getValue()) {
				feverIndicator = true;
				break;
			}
		}
		
		return feverIndicator;
	}

	
}