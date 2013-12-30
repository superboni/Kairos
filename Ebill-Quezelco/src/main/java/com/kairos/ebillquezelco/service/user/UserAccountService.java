package com.kairos.ebillquezelco.service.user;

import java.util.List;

import com.kairos.ebillquezelco.domain.user.UserAccount;

public interface UserAccountService {
	
	void create(UserAccount userAccount);
	void update(UserAccount userAccount);
	List<UserAccount> getAll();
	List<UserAccount> getByName(String name);
	List<UserAccount> getAllEnabled();
	UserAccount getById(String pk);
	UserAccount getByUsername(String username);
	
}