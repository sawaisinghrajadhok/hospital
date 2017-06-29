package com.sawai.medical.model;
 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PHONE_NUMBER")
@TableGenerator(name = "PHONE_NUMBER_GEN", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id" , scope = PhoneNumber.class, generator=ObjectIdGenerators.PropertyGenerator.class)
public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = 7309786906147766015L;

	@Id
	@GeneratedValue(generator = "PHONE_NUMBER_GEN")
	private Long id;
	
	@Column(length = 3)
	private String countryCode;
	
	@Column(length = 12)
	private String number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user", nullable = false)
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
