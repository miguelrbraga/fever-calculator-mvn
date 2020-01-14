package com.miguelbraga.fevercalculator;

public class Patient {
	
	private int age;
	private ReadingType readingType;
	private double reading;
	private TemperatureUnit temperatureUnit;
	private static final TemperatureInterface[] READING_METHODS = new TemperatureInterface[] {
					new OralReading(), new RectalReading(), new ArmpitReading(), new EarReading()
			};
	
	public Patient(int age, ReadingType readingType, double reading, TemperatureUnit temperatureUnit) {
		this.age = age;
		this.readingType = readingType;
		this.reading = reading;
		this.temperatureUnit = temperatureUnit;
	}
	
	private AgeRange determineAgeRange(int age) {
		AgeRange ageRange = AgeRange.YOUNGER_THAN_3;
		
		if (age < AgeRange.YOUNGER_THAN_3.getMaximumAge()) {
			ageRange = AgeRange.YOUNGER_THAN_3;
		} else if (age >= AgeRange.BETWEEN_3_AND_11.getMinimumAge() &&
				age < AgeRange.BETWEEN_3_AND_11.getMaximumAge()) {
			ageRange = AgeRange.BETWEEN_3_AND_11;
		} else if (age >= AgeRange.BETWEEN_11_AND_65.getMinimumAge() &&
				age < AgeRange.BETWEEN_11_AND_65.getMaximumAge()) {
			ageRange = AgeRange.BETWEEN_11_AND_65;
		} else if (age >= AgeRange.OVER_65.getMinimumAge()) {
			ageRange = AgeRange.OVER_65;
		}
		
		return ageRange;
	}
	
	private double convertTemperatureToCelsius(double reading, TemperatureUnit temperatureUnit) {
		double temperatureCelsius = reading;
		
		if (temperatureUnit != TemperatureUnit.CELSIUS) {
			if (temperatureUnit == TemperatureUnit.FAHRENHEIT) {
				temperatureCelsius = (reading - 32) * 5/9;
			} else if (temperatureUnit == TemperatureUnit.KELVIN) {
				temperatureCelsius = reading - 273.15;
			}
		}
		
		return temperatureCelsius;
	}
	
	public boolean hasFever() {
		boolean feverIndicator = false;

		AgeRange patientAgeRange = determineAgeRange(age);
		double patientTemperatureCelsius = convertTemperatureToCelsius(reading, temperatureUnit);
		
		for (TemperatureInterface method: READING_METHODS) {
			if (readingType == method.getReadingType()) {
				feverIndicator = method.hasFever(patientAgeRange, patientTemperatureCelsius);	
			}
		}
		
		return feverIndicator;
	}

}