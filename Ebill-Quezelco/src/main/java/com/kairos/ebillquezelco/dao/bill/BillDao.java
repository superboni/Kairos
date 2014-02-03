package com.kairos.ebillquezelco.dao.bill;

import java.util.Date;
import java.util.List;

import com.kairos.ebillquezelco.dao.GenericDao;
import com.kairos.ebillquezelco.domain.bill.Bill;

public interface BillDao extends GenericDao<Bill, String> {
	public List<Bill> getMultipleBillsToCompute(Date startDate, Date endDate);
	public Bill getSingleBillToCompute(String billId, String oebrNbr);
}
