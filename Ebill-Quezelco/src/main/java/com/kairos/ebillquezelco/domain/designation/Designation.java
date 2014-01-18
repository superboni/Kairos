package com.kairos.ebillquezelco.domain.designation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.kairos.ebillquezelco.domain.user.UserAccount;

@Entity
@Table(name="tblDesignation")
public class Designation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 394213787831045055L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	private String designation;
	
	@NotNull
	@ManyToMany(mappedBy="designations")
	private List<UserAccount> users = new ArrayList<UserAccount>();;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}
	
	public void addUserAccount(UserAccount user) {
		// prevent endless loop
		if (users.contains(user)) 
			return;
		// add new user
		users.add(user);
		user.addDesignation(this);
	}
	
	public void removeUserAccounts(UserAccount user) {
		// prevent endless loop
		if (!users.contains(user))
			return;
		users.remove(user);
		user.removeDesignation(null);
	}

}
