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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "QUALIFICATION")
@TableGenerator(name = "QUALIFICATION_GEN", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id", generator=ObjectIdGenerators.PropertyGenerator.class, scope = Qualification.class)
public class Qualification implements Serializable {
	
	private static final long serialVersionUID = 8840160093185881786L;

	@Id
	@GeneratedValue(generator = "QUALIFICATION_GEN")
	private Long id;
	
	@Column
	private String courseName;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "institution")
	private Institution institution;
	
	@Column
	private String grade;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date passingYear;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person")
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public Institution getInstitution() {
		return institution;
	}


	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Date passingYear) {
		this.passingYear = passingYear;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
