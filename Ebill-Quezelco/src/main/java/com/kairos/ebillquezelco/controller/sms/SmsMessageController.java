package com.kairos.ebillquezelco.controller.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kairos.ebillquezelco.service.sms.SmsMessageService;


@Controller
public class SmsMessageController {

	private static final Logger logger = LoggerFactory.getLogger(SmsMessageController.class);

	@Autowired
	private SmsMessageService smsMessageService;
	
	
	
	
}
