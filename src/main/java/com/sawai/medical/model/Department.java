package com.sawai.medical.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "DEPARTMENT")
@TableGenerator(name = "DEPARTMENT_GENERATOR", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, scope = Department.class)
public class Department implements Serializable {

	private static final long serialVersionUID = -479959449322900621L;

	@Id
	@GeneratedValue(generator = "DEPARTMENT_GENERATOR")
	private Long id;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@Column(name = "INTERNAL_ADDRESS")
	private String internalAddress;

	@Column(name = "DESCRIPTION")
	private String descriptin;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DEPARTMENT_PROVIDERS", joinColumns = @JoinColumn(name = "DEPARTMENT_ID"), inverseJoinColumns = @JoinColumn(name = "PROVIDER_ID"))
	private List<Provider> providers;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DEPARTMENT_WARD", joinColumns = @JoinColumn(name = "DEPARTMENT_ID"), inverseJoinColumns = @JoinColumn(name = "WARD_ID"))
	private List<Ward> wards;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DEPARTMENT_PHONENUMBER", joinColumns = @JoinColumn(name = "DEPARTMENT_ID"), inverseJoinColumns = @JoinColumn(name = "PHONENUMBER_ID"))
	private List<PhoneNumber> departmentPhoneNumbers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public List<Ward> getWards() {
		return wards;
	}

	public void setWards(List<Ward> wards) {
		this.wards = wards;
	}

	public String getInternalAddress() {
		return internalAddress;
	}

	public void setInternalAddress(String internalAddress) {
		this.internalAddress = internalAddress;
	}

	public String getDescriptin() {
		return descriptin;
	}

	public void setDescriptin(String descriptin) {
		this.descriptin = descriptin;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<PhoneNumber> getDepartmentPhoneNumbers() {
		return departmentPhoneNumbers;
	}

	public void setDepartmentPhoneNumbers(
			List<PhoneNumber> departmentPhoneNumbers) {
		this.departmentPhoneNumbers = departmentPhoneNumbers;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName
				+ ", internalAddress=" + internalAddress + ", descriptin="
				+ descriptin + ", providers=" + providers + ", wards=" + wards
				+ ", departmentPhoneNumbers=" + departmentPhoneNumbers + "]";
	}
}
