package com.sawai.medical.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "EXPERIENCE")
@TableGenerator(name = "EXPERIENCE_GEN", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, scope = Experience.class)
public class Experience implements Serializable {
	
	private static final long serialVersionUID = 7783940032554252931L;

	@Id
	@GeneratedValue(generator = "EXPERIENCE_GEN")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "institution")
	private Institution institution;
	
	@Column
	private String areaOfStudy;
	
	@Column
	private String description;

	@ManyToOne
	@JoinColumn(name = "provider", nullable = false)
	private Provider provider;
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getAreaOfStudy() {
		return areaOfStudy;
	}

	public void setAreaOfStudy(String areaOfStudy) {
		this.areaOfStudy = areaOfStudy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", institution=" + institution
				+ ", areaOfStudy=" + areaOfStudy + ", description="
				+ description + ", provider=" + provider + "]";
	}

}
