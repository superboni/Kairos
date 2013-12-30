package com.kairos.ebillquezelco.dao.user;

import java.util.Date;
import java.util.List;

import com.kairos.ebillquezelco.dao.GenericDao;
import com.kairos.ebillquezelco.domain.user.UserAccount;

public interface UserAccountDao extends GenericDao<UserAccount, String> {

	public List<UserAccount> getByName(String name);
	public UserAccount getByUsername(String username);
	public List<UserAccount> getByCreatedDate(Date cDate);
	public List<UserAccount> getAllEnabled();
	
}
