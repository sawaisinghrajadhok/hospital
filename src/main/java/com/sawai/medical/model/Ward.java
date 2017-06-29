package com.sawai.medical.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(name = "Ward")
@Entity
@TableGenerator(name = "WARD_GENERATOR", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, scope = Ward.class)
public class Ward implements Serializable {

	private static final long serialVersionUID = 6515803309977670656L;

	@Id
	@GeneratedValue(generator = "WARD_GENERATOR")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name ="description")
	private String description;
	
	@Column(name = "internal_Address")
	private String internalAddress;
	
	@Column(name = "no_of_beds")
	private Short noOfBeds;
	
	@Column(name = "no_of_patient")
	private Short noOfPatient;
	
	@ElementCollection
	@CollectionTable(name = "WARD_ROOMS")
	private List<String> roomsForWard;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInternalAddress() {
		return internalAddress;
	}
	public void setInternalAddress(String internalAddress) {
		this.internalAddress = internalAddress;
	}
	public Short getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(Short noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public Short getNoOfPatient() {
		return noOfPatient;
	}
	public void setNoOfPatient(Short noOfPatient) {
		this.noOfPatient = noOfPatient;
	}
	public List<String> getRoomsForWard() {
		return roomsForWard;
	}
	public void setRoomsForWard(List<String> roomsForWard) {
		this.roomsForWard = roomsForWard;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Ward [id=" + id + ", name=" + name + ", description="
				+ description + ", internalAddress=" + internalAddress
				+ ", noOfBeds=" + noOfBeds + ", noOfPatient=" + noOfPatient
				+ ", roomsForWard=" + roomsForWard + "]";
	}
}
