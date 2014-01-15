package com.kairos.ebillquezelco.service.designation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.designation.DesignationDao;
import com.kairos.ebillquezelco.domain.designation.Designation;

@Repository("designationService")
@Transactional
public class DesignationServiceImpl implements DesignationService {

	private static final Logger logger = LoggerFactory.getLogger(DesignationServiceImpl.class);
	
	@Autowired
	private DesignationDao designationDao;

	@Override
	public List<Designation> getAll() {
		logger.info("Retrieving all Designation entities");
		try {
			return designationDao.getAll();
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
	
}
