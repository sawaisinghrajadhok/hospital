package com.sawai.medical.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "HOSPITAL")
@TableGenerator(name = "HOSPITAL_GENERATOR", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, scope = Hospital.class)
public class Hospital implements Serializable {

	private static final long serialVersionUID = -5853188308043798824L;
	
	@Id
	@GeneratedValue(generator = "HOSPITAL_GENERATOR")
	private Long id;
	
	@Column(name = "HOSPITAL_NAME")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "HOSPITAL_PROVIDER")
	private List<Provider> providers;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SINCE")
	private Date since;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Department> departments;
	
	private List<Event> events;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Provider> getProviders() {
		return providers;
	}


	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}


	public Date getSince() {
		return since;
	}


	public void setSince(Date since) {
		this.since = since;
	}


	public List<Department> getDepartments() {
		return departments;
	}


	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}


	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", providers="
				+ providers + ", since=" + since + ", departments="
				+ departments + ", events=" + events + "]";
	}
}
