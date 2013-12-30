package com.kairos.ebillquezelco.dao.user;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.user.Roles;
import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.domain.user.UserRoles;

@Repository("userRolesDao")
@Transactional
public class UserRolesDaoImpl extends GenericDaoImpl<UserRoles, String> implements UserRolesDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRoles> getByUserAccount(UserAccount userAccount) {
		Query qry = entityManager.createQuery(
				"SELECT ur FROM UserRoles ur " +
				"WHERE user.id = :userAccount");
		qry.setParameter("userAccount", userAccount.getId());
		return (List<UserRoles>) qry.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRoles> getByRoles(Roles role) {
		Query qry = entityManager.createQuery(
				"SELECT ur FROM UserRoles ur " +
				"WHERE role.id = :role");
		qry.setParameter("role", role.getId());
		return (List<UserRoles>) qry.getResultList();
	}

}
