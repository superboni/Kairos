package com.kairos.ebillquezelco.dao.job;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.job.Job;

@Repository("jobDao")
@Transactional
public class JobDaoImpl extends GenericDaoImpl<Job, Long> implements JobDao {



}
