package com.kairos.ebillquezelco.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.user.UserAccountDao;
import com.kairos.ebillquezelco.domain.user.UserAccount;

@Service("userAccountService")
@Transactional
public class UserAccountServiceImpl implements UserAccountService{

	private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);
	
	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public void create(UserAccount userAccount) {
		try {
			if (userAccount!=null) {
				logger.debug("Creating a new UserAccount entity: " + userAccount.toString());
				userAccountDao.create(userAccount);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getStackTrace().toString());
		}
	}

	@Override
	public void update(UserAccount userAccount) {
		try {
			if (userAccount!=null) {
				logger.debug("Updating the UserAccount entity: " + userAccount.toString());
				userAccountDao.update(userAccount);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getStackTrace().toString());
		}
	}

	@Override
	public List<UserAccount> getAll() {
		logger.debug("Retrieving all UserAccount entities");
		try {
			return userAccountDao.getAll();
		} catch (RuntimeException e) {
			logger.debug(e.getStackTrace().toString());
			return null;
		}
	}

	@Override
	public List<UserAccount> getByName(String name) {
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		try {
			if (name!=null) {
				logger.debug("Retrieving UserAccount entities with name: " + name);
				userAccounts = userAccountDao.getByName(name);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getStackTrace().toString());
		}
		return userAccounts;
	}

	@Override
	public UserAccount getById(String pk) {
		UserAccount userAccount = new UserAccount();
		try {
			if (pk!=null) {
				logger.debug("Retrieving UserAccount entity with id: " + pk);
				userAccount = userAccountDao.getById(pk);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getStackTrace().toString());
		}
		return userAccount;
	}

	@Override
	public UserAccount getByEmail(String email) {
		UserAccount userAccount = new UserAccount();
		try {
			if (email!=null) {
				logger.debug("Retrieving UserAccount entity with email: " + email);
				userAccount = userAccountDao.getByEmail(email);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getStackTrace().toString());
		}
		return userAccount;
	}
	
}
