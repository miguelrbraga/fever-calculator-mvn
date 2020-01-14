package com.miguelbraga.fevercalculator;

public enum AgeRange {
	
	YOUNGER_THAN_3(0,3),
	BETWEEN_3_AND_11(3,11),
	BETWEEN_11_AND_65(11,65),
	OVER_65(65,1000);
	
	private final int minimumAge;
	private final int maximumAge;
	
	private AgeRange(int minimumAge, int maximumAge) {
		this.minimumAge = minimumAge;
		this.maximumAge = maximumAge;
	}

	public int getMinimumAge() {
		return minimumAge;
	}

	public int getMaximumAge() {
		return maximumAge;
	}

}