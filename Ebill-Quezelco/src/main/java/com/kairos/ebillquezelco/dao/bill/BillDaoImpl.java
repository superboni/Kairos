package com.kairos.ebillquezelco.dao.bill;

import java.util.Date;
import java.util.List;

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
	public List<Bill> getMultipleBillsToCompute(Date startDate, Date endDate) {
		Query qry = entityManager.createQuery(
				"SELECT bill FROM Bill bill " +
				"WHERE bill.startDate = :startDate " +
				"AND bill.endDate = :endDate");
		qry.setParameter("startDate", startDate);
		qry.setParameter("endDate", endDate);
		try {
			return (List<Bill>) (qry.getResultList());
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Bill getSingleBillToCompute(String billId, String oebrNbr) {
		Query qry = entityManager.createQuery(
				"SELECT bill FROM Bill bill " +
			    "WHERE LOWER(bill.billId) = :billId " +
				"AND LOWER (bill.oebrNumber) = :oebrNbr");
		qry.setParameter("billId", billId.trim());
		qry.setParameter("oebrNbr", oebrNbr.trim());
		try {
			return (Bill) (qry.getSingleResult());
		} catch (NoResultException e) {
			return null;
		}
	}
}
