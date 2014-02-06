package com.kairos.ebillquezelco.service.adjustment;

public interface Adjustment {
	
	void createAdjustment(String billId, String adjType);
	// Not yet sure for the Parameters
	void updateAdjustment(String adjId);
	void cancelAdjustment (String adjId, String comment);
}
