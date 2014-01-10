package com.kairos.ebillquezelco.service.extras;
import java.util.Date;
import java.util.List;

import com.kairos.ebillquezelco.domain.extras.Announcement;


public interface AnnouncementService {

	public void create(Announcement announcement);
	public void update(Announcement announcement);
	public void delete(String pk);
	public List<Announcement> getAllFromDateRange(Date start, Date end);
	
	
}
