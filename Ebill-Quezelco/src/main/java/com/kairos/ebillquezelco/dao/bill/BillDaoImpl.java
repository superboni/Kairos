package com.kairos.ebillquezelco.dao.bill;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.bill.Bill;

@Repository("billDao")
@Transactional
public class BillDaoImpl extends GenericDaoImpl<Bill, String> implements BillDao {

	@Override
	public BigDecimal getCurrentReading(String billId, String acctNbr, String oebrNbr, Date startDate, Date endDate) {
		Query qry = entityManager.createQuery(
				"SELECT bill.currentReading FROM Bill bill " +
				"WHERE LOWER(bill.billId) = :billId " +
				"AND LOWER(bill.accountNumber) = :acctNbr " +
				"AND LOWER (bill.oebrNumber) = :oebrNbr " +
				"AND bill.startDate = :startDate " +
				"AND bill.endDate = :endDate");
		qry.setParameter("billId", billId.trim());
		qry.setParameter("acctNumber", acctNbr.trim());
		qry.setParameter("oebrNbr", oebrNbr.trim());
		qry.setParameter("startDate", startDate);
		qry.setParameter("endDate", endDate);
		try {
			return (BigDecimal) (qry.getSingleResult());
		} catch (NoResultException e) {
			return null;
		}
	}
}
