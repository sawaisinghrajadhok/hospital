package com.sawai.medical.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority; 
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sawai.medical.enums.Role;

@Entity
@Table(name = "USER")
@TableGenerator(name = "USER_GEN", initialValue = 0, allocationSize = 1)
@JsonIdentityInfo(property = "id" , scope = User.class, generator=ObjectIdGenerators.PropertyGenerator.class)
@Inheritance(strategy=InheritanceType.JOINED) 
public class User implements UserDetails {

	private static final long serialVersionUID = 6207581915480013833L;
	
	@Id
	@GeneratedValue(generator = "USER_GEN")
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String emailId;
	
	@Column
	private String password;
	
	@Column
	private boolean isEnabled = true;
	
	@Column
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true, mappedBy = "user")
	private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER , orphanRemoval = true)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	private Set<Address> addresses = new HashSet<Address>();
	
	@Column
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	private List<Role> roles;
	
	@Column
	private Boolean verified;
	
	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Transient
	private Set<GrantedAuthority> authorities;
	
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return emailId;
	}

	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isEnabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
}
