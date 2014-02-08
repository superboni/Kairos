package com.kairos.ebillquezelco.domain.configuration;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblBillConfiguration")
public class BillConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6994677034579315850L;	
	
	// Fields
	@Id
	private String configName;
	private String description;
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
