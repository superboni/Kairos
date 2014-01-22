package com.kairos.ebillquezelco.domain.role;

public enum SecurityRoles {
	AREA_MANAGER("AREA_MANAGER"),
	CAD("CAD"),
	CASHIER("CASHIER"),
	COLLECTOR("COLLECTOR"),
	IT_PERSONNEL("IT_PERSONNEL"),
	SYSTEM_ADMIN("SYSTEM_ADMIN");
	
	private String secRole;
	
	private SecurityRoles(String secRole) {
		this.secRole = secRole;
	}
	
	public String getSecRole() {
		return secRole;
	}
	
}
