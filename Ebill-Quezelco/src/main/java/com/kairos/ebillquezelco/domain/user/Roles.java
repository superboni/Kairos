package com.kairos.ebillquezelco.domain.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblRoles")
public class Roles implements Serializable {

	private static final long serialVersionUID = -747733913032278788L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	private List<UserAccount> users;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}


}
