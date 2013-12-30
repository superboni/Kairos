package com.kairos.ebillquezelco.domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tblUserAccount")
public class UserAccount implements Serializable {
	
	private static final long serialVersionUID = 826727317693096390L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;

	@Transient
	private String fullName;

	@Column(unique=true)
	private String username;
	
	private String password;
	
	private Date dateCreated;
	
	private Boolean enabled;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName = middleName != null 
						? firstName + " " + middleName.substring(0, 1) + ". " + lastName 
						: firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return "UserAccount: " +
				String.valueOf(this.id) + " " + 
				this.firstName + " " + 
				this.lastName + " " + 
				this.middleName + " " + 
				this.username + " " + 
				this.password + " " + 
				String.valueOf(this.dateCreated) + " " + 
				String.valueOf(this.enabled);
	}
	
}
