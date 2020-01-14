package com.miguelbraga.fevercalculator;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class EarReading implements TemperatureInterface {
	
	private static final Map<AgeRange, Double> celsiusThresholdsEar;
	
	static {
		Map<AgeRange, Double> minTempFeverCelsiusEar = new TreeMap<AgeRange, Double>();
		
		minTempFeverCelsiusEar.put(AgeRange.YOUNGER_THAN_3, 38.0);
		minTempFeverCelsiusEar.put(AgeRange.BETWEEN_3_AND_11, 37.8);
		minTempFeverCelsiusEar.put(AgeRange.BETWEEN_11_AND_65, 37.6);
		minTempFeverCelsiusEar.put(AgeRange.OVER_65, 37.5);
		
		celsiusThresholdsEar = Collections.unmodifiableMap(minTempFeverCelsiusEar);
	}

	public ReadingType getReadingType() {
		return ReadingType.EAR;
	}

	public boolean hasFever(AgeRange ageRange, double reading) {
		boolean feverIndicator = false;
		
		for (Map.Entry<AgeRange, Double> entry: celsiusThresholdsEar.entrySet()) {
			if (ageRange == entry.getKey() && reading > entry.getValue()) {
				feverIndicator = true;
				break;
			}
		}
		
		return feverIndicator;
	}
	
}