package com.kairos.ebillquezelco.service.bill;

import java.util.Date;

public interface BillService {
	void retrieveWheelRates();
	void computeAmountByBill(String billId, String oebrNbr);
	void computeAmountByBatch(Date startDate, Date endDate);
}
