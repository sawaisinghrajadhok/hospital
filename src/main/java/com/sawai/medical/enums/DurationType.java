package com.sawai.medical.enums;

public enum DurationType {
	YEAR("YEAR"), MONTH("MONTH"), WEEK("WEEK");
	
	private String value;
	
	private DurationType(String value) {
		this.value = value;
	}
	
	public String toValue() {
		return value;
	}
}
