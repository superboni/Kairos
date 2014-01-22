package com.kairos.ebillquezelco.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.kairos.ebillquezelco.domain.designation.Designation;
import com.kairos.ebillquezelco.domain.role.Roles;


@Entity
@Table(name="tblUserAccount")
public class UserAccount implements Serializable {
	
	private static final long serialVersionUID = 826727317693096390L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@Size(max=70)
	private String firstName;
	
	@Size(max=70)
	private String middleName;
	
	@NotEmpty
	@Size(max=70)
	private String lastName;

	@Transient
	private String fullName;
	
	@Transient
	private String csvDesignations;
	
	@NotEmpty
	@Size(max=20)
	@Column(unique=true)
	private String username;
	
	@NotEmpty
	@Size(min=5)
	private String password;
	
	private Date dateCreated;
	
	private Boolean enabled;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="role_id")
	private Roles role;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="tblUserDesignation",
			joinColumns=@JoinColumn(name="user", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="designation", referencedColumnName="id"))
	private List<Designation> designations;
	
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
		return fullName = !(middleName==null || "".equals(middleName))
						? firstName + " " + middleName.substring(0, 1) + ". " + lastName 
						: firstName + " " + lastName;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
	public List<Designation> getDesignations() {
		return designations;
	}
	public void setDesignations(List<Designation> designations) {
		this.designations = designations;
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
				String.valueOf(this.enabled) + " " + 
				this.role.getRole().toString() + " " +
				this.designations.size();
	}
	
	public void addDesignation(Designation des) {
		// prevent endless loop
		if (designations.contains(des))
			return;
		designations.add(des);
		des.addUserAccount(this);
	}
	
	public void removeDesignation(Designation des) {
		// prevent endless loop
		if (designations.contains(des))
			return;
		designations.remove(des);
		des.removeUserAccounts(this);
	}
	
	public String getCsvDesignations() {
		String separator = ", ";
		StringBuffer sb = new StringBuffer();
		for (Designation des : designations) {
			sb.append(separator);
			sb.append(des.getDesignation());
		}
		return csvDesignations = (designations.size()==Designation.TOTAL_DESIGNATIONS) 
								? "All towns" 
								: sb.toString().substring(2);
	}
	
}
