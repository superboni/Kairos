package com.kairos.ebillquezelco.service.bill;

import java.util.Date;

import com.kairos.ebillquezelco.domain.bill.Bill;

public interface BillService {
	void retrieveWheelRates();
	void computeAmountByBill(String billId, String oebrNbr);
	void computeAmountByBatch(Date startDate, Date endDate);
	void create(Bill bill);
	void update(Bill bill);
}
