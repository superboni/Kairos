package com.kairos.ebillquezelco.service.extras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.extras.AnnouncementDao;
import com.kairos.ebillquezelco.domain.extras.Announcement;

@Repository("announcementService")
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

	private static final Logger logger = LoggerFactory.getLogger(AnnouncementServiceImpl.class);
	
	@Autowired
	private AnnouncementDao announcementDao;
	
	@Override
	public void create(Announcement announcement) {
		try {
			if (announcement!=null) {
				logger.info("Creating a new Announcement entity: " + announcement.toString());
				announcementDao.create(announcement);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
		}
	}

	@Override
	public void update(Announcement announcement) {
		try {
			if (announcement!=null) {
				logger.info("Updating the Announcement entity: " + announcement.toString());
				announcementDao.update(announcement);
			}
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
		}
	}

	@Override
	public void delete(String pk) {
		
	}

	@Override
	public List<Announcement> getAllFromDateRange(Date start, Date end) throws ParseException {
		List<Announcement> announcements = new ArrayList<Announcement>();
		try {
			if (start != null || end != null) {
				logger.info("Retrieving Announcements from: " + start.toString() + " " + end.toString());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				return announcementDao.getAllFromDateRange(dateFormat.parse(dateFormat.format(start)), dateFormat.parse(dateFormat.format(end)));
			}
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
		}
		return announcements;
	}
	
}
