package com.kairos.ebillquezelco.dao.sms;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.sms.SmsMessage;

@Repository("smsMessageDao")
@Transactional
public class SmsMessageDaoImpl extends GenericDaoImpl<SmsMessage, Long> implements SmsMessageDao {


}
