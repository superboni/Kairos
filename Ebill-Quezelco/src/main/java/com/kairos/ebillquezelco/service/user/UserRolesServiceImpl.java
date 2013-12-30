package com.kairos.ebillquezelco.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.user.UserRolesDao;
import com.kairos.ebillquezelco.domain.user.Roles;
import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.domain.user.UserRoles;

@Service("userRolesService")
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

	private static final Logger logger = LoggerFactory.getLogger(UserRolesServiceImpl.class);
	
	@Autowired
	private UserRolesDao userRolesDao;
	
	@Override
	public List<UserRoles> getByUserAccount(UserAccount userAccount) {
		List<UserRoles> userRoles = new ArrayList<UserRoles>();
		try {
			if (userAccount!=null) {
				logger.info("Retrieving UserRole entities with User Account: " + userAccount.toString());
				userRoles = userRolesDao.getByUserAccount(userAccount);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.debug(e.getLocalizedMessage());
		}
		return userRoles;
	}

	@Override
	public List<UserRoles> getByRoles(Roles role) {
		List<UserRoles> userRoles = new ArrayList<UserRoles>();
		try {
			if (role!=null) {
				logger.info("Retrieving UserRole entities with Role: " + role.toString());
				userRoles = userRolesDao.getByRoles(role);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
		}
		return userRoles;
	}

	@Override
	public List<UserRoles> getAll() {
		try {
			logger.info("Retrieving all UserRole entities");
			return userRolesDao.getAll();
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
			return null;
		}
	}

}
