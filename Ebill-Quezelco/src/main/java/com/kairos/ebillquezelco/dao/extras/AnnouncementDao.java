package com.kairos.ebillquezelco.dao.extras;

import java.util.Date;
import java.util.List;

import com.kairos.ebillquezelco.dao.GenericDao;
import com.kairos.ebillquezelco.domain.extras.Announcement;

public interface AnnouncementDao extends GenericDao<Announcement, String> {
	
	public List<Announcement> getAllFromDateRange(Date start, Date end);

}
