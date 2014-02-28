package com.kairos.ebillquezelco.dao.configuration;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.configuration.BillConfigurationValue;

@Repository("billConfigurationValueDao")
@Transactional
public class BillConfigurationValueDaoImpl extends GenericDaoImpl<BillConfigurationValue, String>
		implements BillConfigurationValueDao {

	@Override
	public List<BillConfigurationValue> getwheelRates() {
		Query qry = entityManager.createQuery("SELECT billWheelRate"
				+ " FROM BillConfigurationValue billWheelRate"
				+ " WHERE billWheelRate.configName = :wheelRate");
		qry.setParameter("wheelrate", "WHEEL_RATE");
		return qry.getResultList();
	}

} 
