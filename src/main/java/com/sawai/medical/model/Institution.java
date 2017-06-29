package com.sawai.medical.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "INSTITUTION")
@TableGenerator(name = "INSTITUTION_GEN", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, scope = Institution.class)
public class Institution implements Serializable {
	
	private static final long serialVersionUID = 6198498363489473915L;

	@Id
	@GeneratedValue(generator = "INSTITUTION_GEN") 
	private Long id;
	
	@Column
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address")
	private Address address;
	
	@Column
	private String superintendentName;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date doj;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dol;
	
	@Column
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSuperintendentName() {
		return superintendentName;
	}

	public void setSuperintendentName(String superintendentName) {
		this.superintendentName = superintendentName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDol() {
		return dol;
	}

	public void setDol(Date dol) {
		this.dol = dol;
	}

}
