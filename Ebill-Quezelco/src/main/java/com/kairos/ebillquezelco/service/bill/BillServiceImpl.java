package com.kairos.ebillquezelco.service.bill;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.bill.BillDao;
import com.kairos.ebillquezelco.service.user.UserAccountServiceImpl;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {

	private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);
	private BigDecimal currReading;
	private List<BigDecimal> wheelRates;
	
	@Autowired
	private BillDao billDao;
	
	@Override
	public void retrieveWheelRates() {
		
	}

	@Override
	public void computeAmountByBill(String billId, String acctNbr, String oebrNbr, Date startDate, Date endDate) {
		BigDecimal totalCurrentCharge = BigDecimal.ZERO;
		BigDecimal computedRate = BigDecimal.ZERO;
		
		currReading = billDao.getCurrentReading(billId, acctNbr, oebrNbr, startDate, endDate);
		Iterator<BigDecimal> wheelRtIter = wheelRates.iterator();
		while (wheelRtIter.hasNext()) {
			computedRate = wheelRtIter.next().multiply(currReading);
			totalCurrentCharge = totalCurrentCharge.add(computedRate);			
		}		
	}

	@Override
	public void computeAmountByBatch() {
	
	}
}
