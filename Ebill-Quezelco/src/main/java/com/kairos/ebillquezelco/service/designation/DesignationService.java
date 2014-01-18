package com.kairos.ebillquezelco.service.designation;
import java.util.List;

import com.kairos.ebillquezelco.domain.designation.Designation;


public interface DesignationService {
	public List<Designation> getAll();
	public Designation getById(Long id);
	public List<Designation> getAllByIds(List<Long> ids);
}
