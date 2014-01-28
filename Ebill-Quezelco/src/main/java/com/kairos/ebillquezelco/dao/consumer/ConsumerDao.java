package com.kairos.ebillquezelco.dao.consumer;

import java.util.List;

import com.kairos.ebillquezelco.dao.GenericDao;
import com.kairos.ebillquezelco.domain.consumer.Consumer;

public interface ConsumerDao extends GenericDao<Consumer, Long> {

	//blueprint
	public List<Consumer> getByName(String name);
	
}
