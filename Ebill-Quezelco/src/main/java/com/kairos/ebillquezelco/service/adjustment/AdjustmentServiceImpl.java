package com.kairos.ebillquezelco.service.adjustment;

import java.util.Date;

import com.kairos.ebillquezelco.domain.adjustment.Adjustment;

public class AdjustmentServiceImpl implements AdjustmentService {

	@Override
	public void createAdjustment(String billId, String adjType) {
		
	}

	@Override
	public void updateAdjustment(String adjId) {
		
	}

	@Override
	public void cancelAdjustment(String adjId, String comment) {
	
	}

	@Override
	public void setDefaultValue(Adjustment adj) {
		adj.setAdjustmentDate(new Date());
		adj.setAdjustmentStatus(adjustmentStatus);
	}
}
