package com.miguelbraga.fevercalculator;

public interface TemperatureInterface {
	
	ReadingType getReadingType();
	boolean hasFever(AgeRange ageRange, double reading);

}