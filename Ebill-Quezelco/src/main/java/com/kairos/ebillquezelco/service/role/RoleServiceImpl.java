package com.kairos.ebillquezelco.service.role;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.role.RoleDao;
import com.kairos.ebillquezelco.domain.role.Roles;

@Repository("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Roles> getAll() {
		logger.info("Retrieving all Role entities");
		try {
			return roleDao.getAll();
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}

	@Override
	public Roles getById(Long id) {
		logger.info("Retrieving a Role entity by id: {}", id);
		try {
			return roleDao.getById(id);
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
	
}
