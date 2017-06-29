package com.sawai.medical.enums;

public enum Role {
	ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");
	
	private String value;
	
	Role(String value) {
		this.value = value;
	}
	
	public String toValue() {
		return value;
	}
}
