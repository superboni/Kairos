package com.kairos.ebillquezelco.controller.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kairos.ebillquezelco.service.job.JobService;

@Controller
public class JobController {

	private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value="/jobs/main", method=RequestMethod.GET)
	public String showJobsMainPage(Model model) {
		logger.info("Displaying all Executed Jobs in View");
		model.addAttribute("jobs", jobService.getAll());
		return "billing/jobsmain";
	}
		
}
