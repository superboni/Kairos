package com.kairos.ebillquezelco.dao.user;


import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.user.UserAccount;

@Repository("userAccountDao")
@Transactional
public class UserAccountDaoImpl extends GenericDaoImpl<UserAccount, Long> implements UserAccountDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccount> getByName(String name) {
		Query qry = entityManager.createQuery(
				"SELECT ua FROM UserAccount ua " +
				"WHERE LOWER(ua.firstName) like :name " +
				"OR LOWER(ua.lastName) like :name " +
				"OR LOWER (ua.middleName) like :name " +
				"AND enabled = 1");
		qry.setParameter("name", "%" + name.toLowerCase() + "%");
		return (List<UserAccount>) qry.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccount> getByCreatedDate(Date cDate) {
		Query qry = entityManager.createQuery(
				"SELECT ua FROM UserAccount ua " +
				"WHERE dateCreated = :cDate " +
				"AND enabled = 1");
		qry.setParameter("cDate", cDate);
		return (List<UserAccount>) qry.getResultList();
	}
	
	@Override
	public UserAccount getByUsername(String username) {
		Query qry = entityManager.createQuery(
				"SELECT ua FROM UserAccount ua " +
				"WHERE LOWER(ua.username) = :username " +
				"AND enabled = 1");
		qry.setParameter("username", username.toLowerCase());
		try {
			return (UserAccount) qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccount> getAllEnabled() {
		Query qry = entityManager.createQuery(
				"SELECT ua FROM UserAccount ua " + 
				"WHERE enabled = 1");
		return (List<UserAccount>) qry.getResultList();
	}
	
}
