package com.kairos.ebillquezelco.service.user;

import java.util.List;

import com.kairos.ebillquezelco.domain.user.Roles;
import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.domain.user.UserRoles;

public interface UserRolesService {
	public List<UserRoles> getByUserAccount(UserAccount userAccount);
	public List<UserRoles> getByRoles(Roles role);
	public List<UserRoles> getAll();
}
