package com.sawai.medical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "ADDRESS")
@TableGenerator(name = "ADDRESS_GEN", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id" , scope = Address.class, generator=ObjectIdGenerators.PropertyGenerator.class)
public class Address {

	@Id
	@GeneratedValue(generator = "ADDRESS_GEN")
	private Long id;
	
	@Column(length = 50)
	private String houseNumber;
	
	@Column
	private String line1;
	
	@Column
	private String line2;
	
	@Column(length = 100)
	private String city;
	
	@Column(length = 100)
	private String state;
	
	@Column(length = 100)
	private String country;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;*/
	
	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	
}
