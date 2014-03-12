package com.kairos.ebillquezelco.service.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.job.JobDao;
import com.kairos.ebillquezelco.domain.job.Job;

@Service("jobService")
@Transactional
public class JobServiceImpl implements JobService {

	
	private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
	
	@Autowired
	private JobDao jobDao;
	
	@Override
	public List<Job> getAll() {
		logger.info("Retrieving all Job entities");
		try {
			return jobDao.getAll();
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
