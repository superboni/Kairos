package com.kairos.ebillquezelco.service.sms;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.sms.SmsMessageDao;
import com.kairos.ebillquezelco.domain.sms.SmsMessage;


@Service("smsMessageService")
@Transactional
public class SmsMessageServiceImpl implements SmsMessageService {

	private static final Logger logger = LoggerFactory.getLogger(SmsMessageServiceImpl.class);
	
	@Autowired
	private SmsMessageDao smsMessageDao;
	
	@Override
	public void create(SmsMessage sms) {
		try {
			if (sms!=null) {
				setDefaultSmsMessageValues(sms);
				logger.info("Creating a new SmsMessage entity: " + sms.toString());
				smsMessageDao.create(sms);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
		}
		
	}

	@Override
	public List<SmsMessage> getAll() {
		logger.info("Retrieving all SmsMessage entities");
		try {
			return smsMessageDao.getAll();
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
	
	
	private void setDefaultSmsMessageValues(SmsMessage sms) {
		sms.setAccountNum("${semaphore.account.number}");
		sms.setApiKey("${semaphore.account.api}");
		sms.setIsSuccessfullySent(true);
	}

}
