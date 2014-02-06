package com.kairos.ebillquezelco.dao.configuration;

import java.util.List;

import com.kairos.ebillquezelco.dao.GenericDao;
import com.kairos.ebillquezelco.domain.configuration.BillConfigurationValue;

public interface BillConfigurationValueDao extends GenericDao<BillConfigurationValue, String> {

	public List<BillConfigurationValue> getwheelRates();
}
