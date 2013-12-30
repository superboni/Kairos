package com.kairos.ebillquezelco.dao.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.user.Roles;

@Repository("rolesDao")
@Transactional
public class RolesDaoImpl extends GenericDaoImpl<Roles, String> implements RolesDao {

}
