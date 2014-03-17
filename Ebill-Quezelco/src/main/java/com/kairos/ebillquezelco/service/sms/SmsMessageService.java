package com.kairos.ebillquezelco.service.sms;

import java.util.List;

import com.kairos.ebillquezelco.domain.sms.SmsMessage;

public interface SmsMessageService {

	void create(SmsMessage sms);
	List<SmsMessage> getAll();
	
}
