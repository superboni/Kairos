package com.kairos.ebillquezelco.service.bill;

import java.util.Date;

public interface BillService {
	void retrieveWheelRates();
	void computeAmountByBill(String billId, String acctNbr, String oebrNbr, Date startDate, Date endDate);
	void computeAmountByBatch();
}
