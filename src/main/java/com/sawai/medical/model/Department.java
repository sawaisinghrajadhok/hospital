package com.sawai.medical.model;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {

	private static final long serialVersionUID = -479959449322900621L;
	
	
	private Long id;
	
	
	private List<Provider> providers;
	
	
	private List<Ward> wards;
	
	
	private String internalAddress;
	
	
	private List<PhoneNumber> phoneNumbers;
	
	
	private String descriptin;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Provider> getProviders() {
		return providers;
	}
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	public List<Ward> getWards() {
		return wards;
	}
	public void setWards(List<Ward> wards) {
		this.wards = wards;
	}
	public String getInternalAddress() {
		return internalAddress;
	}
	public void setInternalAddress(String internalAddress) {
		this.internalAddress = internalAddress;
	}
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getDescriptin() {
		return descriptin;
	}
	public void setDescriptin(String descriptin) {
		this.descriptin = descriptin;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", providers=" + providers + ", wards="
				+ wards + ", internalAddress=" + internalAddress
				+ ", phoneNumbers=" + phoneNumbers + ", descriptin="
				+ descriptin + "]";
	}
}
