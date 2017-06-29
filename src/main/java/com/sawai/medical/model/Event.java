package com.sawai.medical.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "EVENT")
@TableGenerator(name = "EVENT_GENERATOR", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id", scope = Event.class, generator = ObjectIdGenerators.PropertyGenerator.class)
public class Event implements Serializable {
	
	private static final long serialVersionUID = -4195757531637262623L;

	@Id
	@GeneratedValue(generator = "EVENT_GENERATOR")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address venue;

	@Column(name = "description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eventDate")
	private Date eventDate;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "EVENT_PERSON", joinColumns = @JoinColumn(name = "EVENT_ID"), inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
	private List<Person> persons;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "EVENT_PHONENUMBER", joinColumns = @JoinColumn(name = "EVENT_ID"), inverseJoinColumns = @JoinColumn(name = "PHONE_NUMBER_ID"))
	private List<PhoneNumber> phoneNumbers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getVenue() {
		return venue;
	}

	public void setVenue(Address venue) {
		this.venue = venue;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
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
		return "Event [id=" + id + ", venue=" + venue + ", eventDate="
				+ eventDate + ", persons=" + persons + ", phoneNumbers="
				+ phoneNumbers + ", description=" + description + "]";
	}
}
