package com.kairos.ebillquezelco.dao.extras;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.extras.Announcement;

@Repository("announcementDao")
@Transactional
public class AnnouncementDaoImpl extends GenericDaoImpl<Announcement, String> implements AnnouncementDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Announcement> getAllFromDateRange(Date start, Date end) {
		Query qry = entityManager.createQuery(
				"SELECT a FROM Announcement a " +
				"WHERE a.startDate BETWEEN :start AND :end");
		qry.setParameter("start", start);
		qry.setParameter("end", end);
		return (List<Announcement>) qry.getResultList();
	}

}
