package com.kairos.ebillquezelco.domain.configuration;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblBillConfigurationValue")
public class BillConfigurationValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -136750605839457809L;
	
	// Fields
	@Id
	private String configName;
	@Id
	private BigInteger sequence;
	@Id
	private String configOptionName;
	private String description;
	private String value;
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public BigInteger getSequence() {
		return sequence;
	}
	public void setSequence(BigInteger sequence) {
		this.sequence = sequence;
	}
	public String getConfigOptionName() {
		return configOptionName;
	}
	public void setConfigOptionName(String configOptionName) {
		this.configOptionName = configOptionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}	
}