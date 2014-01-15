package com.kairos.ebillquezelco.dao.role;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.role.Roles;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Roles, String> implements RoleDao {


}
