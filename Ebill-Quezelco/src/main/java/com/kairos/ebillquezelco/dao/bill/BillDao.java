package com.kairos.ebillquezelco.dao.bill;

import java.math.BigDecimal;
import java.util.Date;

import com.kairos.ebillquezelco.dao.GenericDao;
import com.kairos.ebillquezelco.domain.bill.Bill;

public interface BillDao extends GenericDao<Bill, String> {

	public BigDecimal getCurrentReading(String billId, String acctNbr, String oebrNbr, Date startDate, Date endDate);
	
}
