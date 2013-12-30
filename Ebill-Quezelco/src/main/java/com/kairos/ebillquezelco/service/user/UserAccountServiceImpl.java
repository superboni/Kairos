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
				logger.info("Creating a new UserAccount entity: " + userAccount.toString());
				userAccountDao.create(userAccount);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
		}
	}

	@Override
	public void update(UserAccount userAccount) {
		try {
			if (userAccount!=null) {
				logger.info("Updating the UserAccount entity: " + userAccount.toString());
				userAccountDao.update(userAccount);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
		}
	}

	@Override
	public List<UserAccount> getAll() {
		logger.info("Retrieving all UserAccount entities");
		try {
			return userAccountDao.getAll();
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public List<UserAccount> getByName(String name) {
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		try {
			if (name!=null) {
				logger.info("Retrieving UserAccount entities with name: " + name);
				userAccounts = userAccountDao.getByName(name);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
		}
		return userAccounts;
	}

	@Override
	public UserAccount getById(String pk) {
		UserAccount userAccount = new UserAccount();
		try {
			if (pk!=null) {
				logger.info("Retrieving UserAccount entity with id: " + pk);
				userAccount = userAccountDao.getById(pk);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
		}
		return userAccount;
	}

	@Override
	public UserAccount getByUsername(String username) {
		UserAccount userAccount = new UserAccount();
		try {
			if (username!=null) {
				logger.info("Retrieving UserAccount entity with username: " + username);
				userAccount = userAccountDao.getByUsername(username);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
		}
		return userAccount;
	}

	@Override
	public List<UserAccount> getAllEnabled() {
		logger.info("Retrieving all Enabled UserAccount entities");
		try {
			return userAccountDao.getAllEnabled();
		} catch (RuntimeException e) {
			logger.debug(e.getLocalizedMessage());
			return null;
		}
	}
	
}
