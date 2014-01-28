package com.kairos.ebillquezelco.dao.consumer;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.consumer.Consumer;

// name repository
@Repository("consumerDao")

// tells spring that this class contains methods handles database transactions specific in this class
@Transactional

public class ConsumerDaoImpl extends GenericDaoImpl<Consumer, Long> implements
		ConsumerDao {

	@Override
	public List<Consumer> getByName(String name) {
		return null;
	}

}
