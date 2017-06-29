package com.sawai.medical.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "PROVIDERS")
@TableGenerator(name = "PROVIDERS_GEN", initialValue = 0, allocationSize = 1)
@PrimaryKeyJoinColumn(name="id")
public class Provider extends Person implements Serializable {

	private static final long serialVersionUID = 2486221268213686992L;
	
	@Column
	private short rating;
	
	@Column
	private String designation;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
	private List<Experience> experiences;
	
	@Column
	private float totalExperience;
	
	public float getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(float totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	} 
	
}
