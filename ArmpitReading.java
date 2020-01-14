package com.miguelbraga.fevercalculator;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ArmpitReading implements TemperatureInterface {
	
	private static final Map<AgeRange, Double> celsiusThresholdsArmpit;
	
	static {
		Map<AgeRange, Double> minTempFeverCelsiusArmpit = new TreeMap<AgeRange, Double>();
		
		minTempFeverCelsiusArmpit.put(AgeRange.YOUNGER_THAN_3, 37.3);
		minTempFeverCelsiusArmpit.put(AgeRange.BETWEEN_3_AND_11, 36.7);
		minTempFeverCelsiusArmpit.put(AgeRange.BETWEEN_11_AND_65, 36.9);
		minTempFeverCelsiusArmpit.put(AgeRange.OVER_65, 36.3);
		
		celsiusThresholdsArmpit = Collections.unmodifiableMap(minTempFeverCelsiusArmpit);
	}

	public ReadingType getReadingType() {
		return ReadingType.ARMPIT;
	}

	public boolean hasFever(AgeRange ageRange, double reading) {
		boolean feverIndicator = false;
		
		for (Map.Entry<AgeRange, Double> entry: celsiusThresholdsArmpit.entrySet()) {
			if (ageRange == entry.getKey() && reading > entry.getValue()) {
				feverIndicator = true;
				break;
			}
		}
		
		return feverIndicator;
	}

}
