package com.kairos.ebillquezelco.dao.user;

import java.util.List;

import com.kairos.ebillquezelco.dao.GenericDao;
import com.kairos.ebillquezelco.domain.user.Roles;
import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.domain.user.UserRoles;

public interface UserRolesDao extends GenericDao<UserRoles, String> {
	public List<UserRoles> getByUserAccount(UserAccount userAccount);
	public List<UserRoles> getByRoles(Roles role);
}
