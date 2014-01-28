package com.kairos.ebillquezelco.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.consumer.ConsumerDao;

// service type bean
@Service("consumerService")
@Transactional
public class ConsumerServiceImpl implements ConsumerService {
	
	@Autowired 
	private ConsumerDao consumerDao;

}
