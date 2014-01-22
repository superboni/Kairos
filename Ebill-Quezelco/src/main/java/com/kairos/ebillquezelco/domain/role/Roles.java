package com.kairos.ebillquezelco.domain.role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.kairos.ebillquezelco.domain.user.UserAccount;

@Entity
@Table(name="tblRoles")
public class Roles implements Serializable {

	private static final long serialVersionUID = -747733913032278788L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String role;
	
	@NotNull
	@OneToMany(mappedBy = "role")
	private List<UserAccount> users = new ArrayList<UserAccount>();
	
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
