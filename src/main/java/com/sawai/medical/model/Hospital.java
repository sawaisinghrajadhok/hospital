package com.sawai.medical.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Hospital implements Serializable {

	private static final long serialVersionUID = -5853188308043798824L;
	
	private Long id;
	
	
	private String name;
	
	
	private List<Provider> providers;
	
	
	private Date since;
	
	
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
