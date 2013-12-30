package com.kairos.ebillquezelco.dao.user;


import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.user.UserAccount;

@Repository("userAccountDao")
@Transactional
public class UserAccountDaoImpl extends GenericDaoImpl<UserAccount, String> implements UserAccountDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccount> getByName(String name) {
		Query qry = entityManager.createQuery(
				"SELECT ua FROM UserAccount ua " +
				"WHERE LOWER(ua.firstName) like :name " +
				"OR LOWER(ua.lastName) like :name " +
				"OR LOWER (ua.middleName) like :name" );
		qry.setParameter("name", "%" + name.toLowerCase() + "%");
		return (List<UserAccount>) qry.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccount> getByCreatedDate(Date cDate) {
		Query qry = entityManager.createQuery(
				"SELECT ua FROM UserAccount ua " +
				"WHERE dateCreated = :cDate");
		qry.setParameter("cDate", cDate);
		return (List<UserAccount>) qry.getResultList();
	}
	
	@Override
	public UserAccount getByUsername(String username) {
		Query qry = entityManager.createQuery(
				"SELECT ua FROM UserAccount ua " +
				"WHERE LOWER(ua.username) = :username");
		qry.setParameter("username", username.toLowerCase());
		return (UserAccount) qry.getSingleResult();
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
