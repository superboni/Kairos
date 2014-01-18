package com.kairos.ebillquezelco.service.role;
import java.util.List;

import com.kairos.ebillquezelco.domain.role.Roles;


public interface RoleService {

	public List<Roles> getAll();
	public Roles getById(Long id);
	
}
