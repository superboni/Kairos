package com.kairos.ebillquezelco.service.adjustment;

import com.kairos.ebillquezelco.domain.adjustment.Adjustment;

public interface AdjustmentService {
	
	void createAdjustment(String billId, String adjType);
	// Not yet sure for the Parameters
	void updateAdjustment(String adjId);
	void cancelAdjustment (String adjId, String comment);
	void setDefaultValue(Adjustment adj);
}
