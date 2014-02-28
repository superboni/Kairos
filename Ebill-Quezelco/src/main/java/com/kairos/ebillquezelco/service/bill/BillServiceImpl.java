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
import com.kairos.ebillquezelco.dao.configuration.BillConfigurationValueDao;
import com.kairos.ebillquezelco.domain.bill.Bill;
import com.kairos.ebillquezelco.domain.configuration.BillConfigurationValue;
import com.kairos.ebillquezelco.service.user.UserAccountServiceImpl;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {

	private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);
	
	private List<BigDecimal> wheelRates;
	
	@Autowired
	private BillDao billDao;
	
	@Autowired
	private BillConfigurationValueDao billConfigDao;
	
	@Override
	public void retrieveWheelRates() {
		BigDecimal wheelRateIndividualValue;
		Iterator <BillConfigurationValue> billConfigIter = billConfigDao.getwheelRates().iterator();
		while (billConfigIter.hasNext()) {
			wheelRateIndividualValue = BigDecimal.valueOf(Long.valueOf(billConfigIter.next().getValue().trim()));
			wheelRates.add(wheelRateIndividualValue);
		}
	}

	@Override
	public void computeAmountByBill(String billId,String oebrNbr) {
		BigDecimal totalCurrentCharge = BigDecimal.ZERO;
		BigDecimal computedRate = BigDecimal.ZERO;
		Bill bill = billDao.getSingleBillToCompute(billId, oebrNbr);
		if(bill.getCurrentBillAmount().equals(null) || !(bill.equals(BigDecimal.ZERO))) {
			// Raise warning here
			// If Condition below is just dummy. This should be if the user selected Proceed from the warning raised.
			if (computedRate.equals(null)) {
				// Compute for current charge
				totalCurrentCharge = computeForCurrentGeneratedCharge(bill.getCurrentReading());
				
				// Update Bill Current Generated Charge
				bill.setCurrentBillAmount(totalCurrentCharge);
			}
			else {
				return;
			}
		}
	}

	@Override
	public void computeAmountByBatch(Date startDate, Date endDate) {
		BigDecimal totalCurrentCharge = BigDecimal.ZERO;
		BigDecimal computedRate = BigDecimal.ZERO;
		Bill bill;
		
		List<Bill> billList = billDao.getMultipleBillsToCompute(startDate, endDate);
		
		if (billList.isEmpty()) {
			// add error
		}
		
		Iterator<Bill> billIter = billList.iterator();
		while (billIter.hasNext()) {
			bill = billIter.next();
			if(bill.getCurrentBillAmount().equals(null) || !(bill.equals(BigDecimal.ZERO))) {
				// Raise warning here
				// If Condition below is just dummy. This should be if the user selected Proceed from the warning raised.
				if (computedRate.equals(null)) {
					// Compute for current charge
					totalCurrentCharge = computeForCurrentGeneratedCharge(bill.getCurrentReading());
					
					// Update Bill Current Generated Charge
					bill.setCurrentBillAmount(totalCurrentCharge);
				}
				else {
					return;
				}
			}
		}
	}
	
	public BigDecimal computeForCurrentGeneratedCharge (BigDecimal currReading) {
		BigDecimal totalCurrentCharge = BigDecimal.ZERO;
		BigDecimal computedRate = BigDecimal.ZERO;
		
		Iterator<BigDecimal> wheelRtIter = wheelRates.iterator();
		while (wheelRtIter.hasNext()) {
			computedRate = wheelRtIter.next().multiply(currReading);
			totalCurrentCharge = totalCurrentCharge.add(computedRate);			
		}
		
		return totalCurrentCharge;
	}

	@Override
	public void create(Bill bill) {
		try {
			if (bill!=null) {
				logger.info("Creating a new Bill entity: " + bill.toString());
				billDao.create(bill);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
		}
	}

	@Override
	public void update(Bill bill) {
		try {
			if (bill!=null) {
				logger.info("Updating the Bill entity: " + bill.toString());
				billDao.update(bill);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}
	}
}