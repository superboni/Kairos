package com.kairos.ebillquezelco.service.user;

import java.util.List;

import com.kairos.ebillquezelco.domain.user.UserAccount;

public interface UserAccountService {
	
	void create(UserAccount userAccount);
	void update(UserAccount userAccount);
	void delete(Long id);
	List<UserAccount> getByName(String name);
	List<UserAccount> getAll();
	List<UserAccount> getAllEnabled();
	UserAccount getById(Long pk);
	UserAccount getByUsername(String username);
	
}